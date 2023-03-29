package com.somenthingnice.testtask.datasource.local.sources.history

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.somenthingnice.testtask.datasource.local.entity.history.HistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: HistoryEntity)


    @Query("SELECT * FROM history ORDER BY timeCreated DESC")
    fun getHistory(): Flow<List<HistoryEntity>>

}