package com.vrgs.abookpro.core.network.flow

import com.somenthingnice.testtask.core.data.common.isFailure
import com.somenthingnice.testtask.core.data.common.isLoading
import com.somenthingnice.testtask.core.data.common.isSuccess
import com.somenthingnice.testtask.core.data.entity.Transaction
import com.somenthingnice.testtask.core.data.entity.TransactionStatus
import com.somenthingnice.testtask.core.data.flow.FlowTransaction
import kotlinx.coroutines.flow.combineTransform


fun <A, B, C> combineTransaction(
    transaction0: FlowTransaction<A>,
    transaction1: FlowTransaction<B>,
    block: suspend (A, B) -> C
) = combineTransform(
    transaction0,
    transaction1
) { result0, result1 ->
    if (result0.isLoading() || result1.isLoading())
        emit(Transaction.Loading)
    if (result0.isFailure() || result1.isFailure()) {
        emit(Transaction.Failure(TransactionStatus.GENERAL_ERROR, null))
        return@combineTransform
    }
    if (result0.isSuccess() && result1.isSuccess())
        emit(
            block(
                (result0 as Transaction.Success<A>).data,
                (result1 as Transaction.Success<B>).data
            )
        )
}

fun <A, B, C, D> combineTransaction(
    transaction0: FlowTransaction<A>,
    transaction1: FlowTransaction<B>,
    transaction2: FlowTransaction<C>,
    block: suspend (A, B, C) -> D
) = combineTransform(
    transaction0,
    transaction1,
    transaction2
) { result0, result1, result2 ->
    if (result0.isLoading() || result1.isLoading() || result2.isLoading())
        emit(Transaction.Loading)
    if (result0.isFailure() || result1.isFailure() || result2.isFailure()) {
        emit(Transaction.Failure(TransactionStatus.GENERAL_ERROR, null))
        return@combineTransform
    }
    if (result0.isSuccess() && result1.isSuccess())
        emit(
            block(
                (result0 as Transaction.Success<A>).data,
                (result1 as Transaction.Success<B>).data,
                (result2 as Transaction.Success<C>).data
            )
        )
}

fun <A, B, C, D, E> combineTransaction(
    transaction0: FlowTransaction<A>,
    transaction1: FlowTransaction<B>,
    transaction2: FlowTransaction<C>,
    transaction3: FlowTransaction<D>,
    block: suspend (A, B, C, D) -> E
) = combineTransform(
    transaction0,
    transaction1,
    transaction2,
    transaction3
) { result0, result1, result2, result3 ->
    if (result0.isLoading() || result1.isLoading() || result2.isLoading() || result3.isLoading())
        emit(Transaction.Loading)
    if (result0.isFailure() || result1.isFailure() || result2.isFailure() || result3.isFailure()) {
        emit(Transaction.Failure(TransactionStatus.GENERAL_ERROR, null))
        return@combineTransform
    }
    if (result0.isSuccess() && result1.isSuccess())
        emit(
            block(
                (result0 as Transaction.Success<A>).data,
                (result1 as Transaction.Success<B>).data,
                (result2 as Transaction.Success<C>).data,
                (result3 as Transaction.Success<D>).data
            )
        )
}