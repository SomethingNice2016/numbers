package com.somenthingnice.testtask.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.somenthingnice.testtask.datasource.local.LocalDatabase.Companion.VERSION
import com.somenthingnice.testtask.datasource.local.entity.history.HistoryEntity
import com.somenthingnice.testtask.datasource.local.entity.numbers.NumberEntity
import com.somenthingnice.testtask.datasource.local.sources.history.HistoryDao
import com.somenthingnice.testtask.datasource.local.sources.numbers.NumberDao


@Database(
    entities = [
        NumberEntity::class, HistoryEntity::class
    ],
    version = VERSION,
    exportSchema = true
)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun getNumbersDao(): NumberDao

    abstract fun getHistoryDao(): HistoryDao

    companion object {
        const val NAME = "TestTaskLocalDatabase"
        const val VERSION = 1
    }
}