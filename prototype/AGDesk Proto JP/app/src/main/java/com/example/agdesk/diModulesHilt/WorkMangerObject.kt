package com.example.agdesk.diModulesHilt

import com.example.agdesk.WorkManger.SyncWorkerFactory
import com.example.agdesk.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object WorkMangerObject {

    @Provides
    @Singleton
    fun provideWorkerFactory(
        networkRepository: NetworkRepository,
    ): SyncWorkerFactory {
        return SyncWorkerFactory(networkRepository)
    }

}