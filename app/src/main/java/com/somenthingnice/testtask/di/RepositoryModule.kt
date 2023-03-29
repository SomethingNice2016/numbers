package com.somenthingnice.testtask.di

import com.somenthingnice.testtask.repositiry.history.HistoryRepository
import com.somenthingnice.testtask.repositiry.history.HistoryRepositoryImpl
import com.somenthingnice.testtask.repositiry.numbers.NumbersRepository
import com.somenthingnice.testtask.repositiry.numbers.NumbersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    fun bindNumbersRepository(impl: NumbersRepositoryImpl): NumbersRepository

    @Binds
    fun bindHistoryRepository(impl: HistoryRepositoryImpl): HistoryRepository

}