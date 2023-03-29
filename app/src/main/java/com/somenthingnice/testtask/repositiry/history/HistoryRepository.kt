package com.somenthingnice.testtask.repositiry.history

import com.somenthingnice.testtask.core.data.entity.Transaction
import com.somenthingnice.testtask.entity.hisoty.HistoryItem
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    suspend fun saveToHistory(number: Long): Transaction<Unit>

    fun getHistory(): Flow<List<HistoryItem>>

}