package com.somenthingnice.testtask.domain.hisotry

import com.somenthingnice.testtask.di.IODispatcher
import com.somenthingnice.testtask.repositiry.history.HistoryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(
    private val historyRepository: HistoryRepository,
    @IODispatcher
    private val dispatcher: CoroutineDispatcher
) {

    operator fun invoke() = historyRepository.getHistory()
        .flowOn(dispatcher)

}