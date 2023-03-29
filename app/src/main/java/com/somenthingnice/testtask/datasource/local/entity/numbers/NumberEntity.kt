package com.somenthingnice.testtask.datasource.local.entity.numbers

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.somenthingnice.testtask.entity.number.NumberInfo

@Entity(tableName = "number")
data class NumberEntity(
    @PrimaryKey
    val number: Long,
    val info: String
)


fun NumberEntity.toDomain() = NumberInfo(
    number = number,
    info = info
)

fun NumberInfo.toEntity() = NumberEntity(
    number = number,
    info = info
)