package com.example.agdesk.dependencyInjectionModulesHilt
import com.example.agdesk.WorkManger.CustomWorkerFactory
import com.example.agdesk.DomainLayer.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object WorkerModule {

    @Provides
    @Singleton
    fun provideWorkerFactory(
        networkRepository: NetworkRepository,
    ): CustomWorkerFactory {
        return CustomWorkerFactory(networkRepository)
    }

}