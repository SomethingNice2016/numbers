package com.somenthingnice.testtask.datasource.local.sources.history

import com.somenthingnice.testtask.core.data.entity.Transaction
import com.somenthingnice.testtask.entity.hisoty.HistoryItem
import kotlinx.coroutines.flow.Flow

interface HistoryLocalSource {

    suspend fun saveToHistory(number: Long): Transaction<Unit>

    fun getHistory(): Flow<List<HistoryItem>>

}