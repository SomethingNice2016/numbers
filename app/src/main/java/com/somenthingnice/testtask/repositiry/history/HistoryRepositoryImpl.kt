package com.somenthingnice.testtask.repositiry.history

import com.somenthingnice.testtask.datasource.local.sources.history.HistoryLocalSource
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val local: HistoryLocalSource
): HistoryRepository {

    override suspend fun saveToHistory(number: Long) = local.saveToHistory(number)

    override fun getHistory() = local.getHistory()
}