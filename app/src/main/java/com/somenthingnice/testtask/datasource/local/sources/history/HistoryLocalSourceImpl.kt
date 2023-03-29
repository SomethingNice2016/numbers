package com.somenthingnice.testtask.datasource.local.sources.history

import com.somenthingnice.testtask.core.common.time.TimeUtils
import com.somenthingnice.testtask.core.data.coroutines.formAction
import com.somenthingnice.testtask.core.data.entity.Transaction
import com.somenthingnice.testtask.datasource.local.entity.history.HistoryEntity
import com.somenthingnice.testtask.datasource.local.entity.history.toDomain
import com.somenthingnice.testtask.entity.hisoty.HistoryItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HistoryLocalSourceImpl @Inject constructor(
    private val historyDao: HistoryDao,
    private val timeUtils: TimeUtils
) : HistoryLocalSource {
    override suspend fun saveToHistory(number: Long) = Transaction.formAction {
        historyDao.insert(
            entity = HistoryEntity(
                timeCreated = timeUtils.getCurrentTime(),
                number = number
            )
        )
    }

    override fun getHistory() = historyDao.getHistory().map { list ->
        list.map { entity ->
            entity.toDomain()
        }
    }
}