package com.somenthingnice.testtask.di

import android.content.Context
import androidx.room.Room
import com.somenthingnice.testtask.datasource.local.LocalDatabase
import com.somenthingnice.testtask.datasource.local.LocalDatabase.Companion.NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): LocalDatabase =
        Room.databaseBuilder(context, LocalDatabase::class.java, NAME)
            .build()

    @Provides
    @Singleton
    fun providesNumbersDao(database: LocalDatabase) = database.getNumbersDao()

    @Provides
    @Singleton
    fun providesHistoryDao(database: LocalDatabase) = database.getHistoryDao()

}