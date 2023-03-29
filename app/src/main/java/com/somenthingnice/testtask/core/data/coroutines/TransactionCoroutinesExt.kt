package com.somenthingnice.testtask.core.data.coroutines

import com.somenthingnice.testtask.core.data.entity.Transaction
import com.somenthingnice.testtask.core.data.entity.TransactionStatus
import com.somenthingnice.testtask.core.data.exception.fromException

suspend fun <T> Transaction.Companion.formAction(action: suspend () -> T): Transaction<T> {
    return try {
        Transaction.Success<T>(action(), TransactionStatus.SUCCESS)
    } catch (t: Throwable) {
        Transaction.Failure(t.fromException(), t)
    }
}
