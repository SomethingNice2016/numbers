package com.somenthingnice.testtask.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainDispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IODispatcher

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MainScope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class IOScope


@Module
@InstallIn(SingletonComponent::class)
class CoroutinesModule {

    @MainDispatcher
    @Provides
    fun provideMainDispatcher() = Dispatchers.Main

    @IODispatcher
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO

    @MainScope
    @Provides
    fun providesMainScope(@MainDispatcher dispatcher: CoroutineDispatcher) =
        CoroutineScope(dispatcher)

    @IOScope
    @Provides
    fun providesIoScope(@IODispatcher dispatcher: CoroutineDispatcher) =
        CoroutineScope(dispatcher)
}