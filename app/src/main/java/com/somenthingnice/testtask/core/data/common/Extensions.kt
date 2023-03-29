package com.somenthingnice.testtask.core.data.common

import com.somenthingnice.testtask.core.data.entity.Transaction
import com.somenthingnice.testtask.core.data.entity.TransactionStatus

fun <T> Transaction<T>.isSuccess() = this is Transaction.Success<T>

fun <T> Transaction<T>.isFailure() = this is Transaction.Failure

fun <T> Transaction<T>.isLoading() = this is Transaction.Loading

suspend fun <T> Transaction<T>.onSuccess(block: suspend (T) -> Unit): Transaction<T> {
    when (this) {
        is Transaction.Failure -> Unit
        is Transaction.Loading -> Unit
        is Transaction.Success -> block(data)
    }
    return this
}

suspend fun <T> Transaction<T>.onFailure(block: suspend (TransactionStatus, Throwable?) -> Unit): Transaction<T> {
    when (this) {
        is Transaction.Failure -> block(status, cause)
        is Transaction.Loading -> Unit
        is Transaction.Success -> Unit
    }
    return this
}

suspend fun <T> Transaction<T>.onLoading(block: suspend () -> Unit): Transaction<T> {
    when (this) {
        is Transaction.Failure -> Unit
        is Transaction.Loading -> block()
        is Transaction.Success -> Unit
    }
    return this
}