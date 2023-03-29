package com.somenthingnice.testtask.datasource.local.sources.numbers

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.somenthingnice.testtask.datasource.local.entity.numbers.NumberEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NumberDao {

    @Query("SELECT * FROM number WHERE number=:number")
    fun getInfoByNumber(number: Long): Flow<NumberEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNumberInfo(info: NumberEntity)

}