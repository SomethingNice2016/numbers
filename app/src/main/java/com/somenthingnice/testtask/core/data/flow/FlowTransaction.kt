package com.somenthingnice.testtask.core.data.flow

import com.somenthingnice.testtask.core.data.entity.Transaction
import com.somenthingnice.testtask.core.data.entity.TransactionStatus
import com.somenthingnice.testtask.core.data.exception.fromException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

typealias FlowTransaction<T> = Flow<Transaction<T>>


fun <T> Transaction.Companion.flowWrap(
    block: suspend () -> T
): FlowTransaction<T> = flow {
    emit(Transaction.Loading)
    emit(Transaction.Success(block(), TransactionStatus.SUCCESS))
}.catch { exception ->
    emit(Transaction.Failure(exception.fromException(), exception))
}

fun <T> Flow<T?>.wrap(): FlowTransaction<T> = flow {
    emit(Transaction.Loading)
    emit(Transaction.Success(filterNotNull().first(), TransactionStatus.SUCCESS))
}.catch { exception ->
    emit(Transaction.Failure(exception.fromException(), exception))
}

fun <IN, OUT> FlowTransaction<IN>.transform(
    transformer: suspend (IN) -> OUT
): FlowTransaction<OUT> = map { result ->
    when (result) {
        is Transaction.Failure -> result
        is Transaction.Loading -> result
        is Transaction.Success -> Transaction.Success(transformer(result.data), result.status)
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun <IN, OUT> FlowTransaction<IN>.flatTransform(
    transformer: suspend (IN) -> FlowTransaction<OUT>
): FlowTransaction<OUT> = transformLatest { result ->
    when (result) {
        is Transaction.Failure -> emit(result)
        is Transaction.Loading -> emit(result)
        is Transaction.Success -> emitAll(transformer(result.data))
    }
}

fun <IN, OUT> FlowTransaction<IN>.unfold(
    loading: suspend () -> OUT,
    success: suspend (data: IN) -> OUT,
    failure: suspend (cause: Throwable?, status: TransactionStatus) -> OUT
): Flow<OUT> = map { result ->
    when (result) {
        is Transaction.Failure -> failure(result.cause, result.status)
        is Transaction.Loading -> loading()
        is Transaction.Success -> success(result.data)
    }
}.catch { exception ->
    emit(failure(exception, exception.fromException()))
}

fun <T> FlowTransaction<T>.onSuccess(
    block: suspend (T) -> Unit
): FlowTransaction<T> = onEach { result ->
    when (result) {
        is Transaction.Failure -> Unit
        is Transaction.Loading -> Unit
        is Transaction.Success -> block(result.data)
    }
}.catch { exception ->
    emit(Transaction.Failure(exception.fromException(), exception))
}

fun <T> FlowTransaction<T>.onFailure(
    block: suspend (TransactionStatus, Throwable?) -> Unit
): FlowTransaction<T> = onEach { result ->
    when (result) {
        is Transaction.Failure -> block(result.status, result.cause)
        is Transaction.Loading -> Unit
        is Transaction.Success -> Unit
    }
}.catch { exception ->
    emit(Transaction.Failure(exception.fromException(), exception))
}

@OptIn(ExperimentalCoroutinesApi::class)
fun <T> FlowTransaction<T>.getOrElse(
    onElse: suspend () -> T
): Flow<T> = transformLatest { transaction ->
    when (transaction) {
        is Transaction.Failure -> emit(onElse())
        is Transaction.Loading -> Unit
        is Transaction.Success -> emit(transaction.data)
    }
}

@OptIn(ExperimentalCoroutinesApi::class)
fun <T> FlowTransaction<T>.getOrNull(): Flow<T?> = transformLatest { transaction ->
    when (transaction) {
        is Transaction.Failure -> emit(null)
        is Transaction.Loading -> Unit
        is Transaction.Success -> emit(transaction.data)
    }
}

fun <T> FlowTransaction<T?>.filterNotNull(): FlowTransaction<T> = transformLatest { transaction ->
    when (transaction) {
        is Transaction.Failure -> emit(transaction)
        is Transaction.Loading -> emit(transaction)
        is Transaction.Success -> transaction.data?.let { data ->
            emit(Transaction.Success(data, TransactionStatus.SUCCESS))
        }
    }
}


