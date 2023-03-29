package com.somenthingnice.testtask.di

import com.somenthingnice.testtask.core.common.time.TimeUtils
import com.somenthingnice.testtask.core.common.time.TimeUtilsImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    companion object {

        @Singleton
        @Provides
        fun provideTimeUtils(): TimeUtils = TimeUtilsImpl()

    }

}