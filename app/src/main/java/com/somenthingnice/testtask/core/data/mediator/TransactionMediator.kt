package com.somenthingnice.testtask.core.data.mediator

import com.somenthingnice.testtask.core.data.common.isFailure
import com.somenthingnice.testtask.core.data.common.isSuccess
import com.somenthingnice.testtask.core.data.entity.Transaction
import com.somenthingnice.testtask.core.data.exception.fromException
import com.somenthingnice.testtask.core.data.flow.FlowTransaction
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine

class TransactionMediator<T>(
    private val remote: () -> FlowTransaction<T>,
    private val local: () -> FlowTransaction<T>,
    private val onCache: suspend (T) -> Unit
) {

    fun execute() = combine(
        remote.invoke(),
        local.invoke()
    ) { remoteData, localData ->
        when {
            remoteData.isFailure() && !localData.isSuccess() -> remoteData
            remoteData.isSuccess() -> {
                onCache((remoteData as Transaction.Success<T>).data)
                remoteData
            }
            remoteData.isFailure() && localData.isSuccess() -> localData
            else -> localData
        }
    }.catch { exception ->
        emit(Transaction.Failure(exception.fromException(), exception))
    }

}