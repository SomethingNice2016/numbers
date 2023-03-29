package com.somenthingnice.testtask.di

import com.somenthingnice.testtask.datasource.local.sources.history.HistoryLocalSource
import com.somenthingnice.testtask.datasource.local.sources.history.HistoryLocalSourceImpl
import com.somenthingnice.testtask.datasource.local.sources.numbers.NumbersLocalSource
import com.somenthingnice.testtask.datasource.local.sources.numbers.NumbersLocalSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface LocalModule {

    @Binds
    fun bindsNumbersLocalSource(impl: NumbersLocalSourceImpl): NumbersLocalSource

    @Binds
    fun binsHistoryLocalSource(impl: HistoryLocalSourceImpl): HistoryLocalSource

}