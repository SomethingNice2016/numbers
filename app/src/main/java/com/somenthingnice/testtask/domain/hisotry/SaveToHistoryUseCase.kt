package com.somenthingnice.testtask.domain.hisotry

import com.somenthingnice.testtask.di.IODispatcher
import com.somenthingnice.testtask.repositiry.history.HistoryRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveToHistoryUseCase @Inject constructor(
    private val historyRepository: HistoryRepository,
    @IODispatcher
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(number: Long) = withContext(dispatcher) {
        historyRepository.saveToHistory(number)
    }

}