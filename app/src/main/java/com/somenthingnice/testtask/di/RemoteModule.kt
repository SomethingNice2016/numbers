package com.somenthingnice.testtask.di

import com.somenthingnice.testtask.datasource.remote.numbers.NumbersRemoteSource
import com.somenthingnice.testtask.datasource.remote.numbers.NumbersRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface RemoteModule {

    @Binds
    fun bindsNumbersRemoteSource(impl: NumbersRemoteSourceImpl): NumbersRemoteSource

}