package com.somenthingnice.testtask.datasource.local.entity.history

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.somenthingnice.testtask.entity.hisoty.HistoryItem

@Entity(tableName = "history")
data class HistoryEntity(
    @PrimaryKey
    val timeCreated: Long,
    val number: Long
)

fun HistoryEntity.toDomain(): HistoryItem {
    return HistoryItem(
        id = timeCreated,
        number = number
    )
}



