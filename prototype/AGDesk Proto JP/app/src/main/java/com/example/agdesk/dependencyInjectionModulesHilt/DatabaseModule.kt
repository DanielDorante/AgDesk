package com.example.agdesk.dependencyInjectionModulesHilt

import android.content.Context
import com.example.agdesk.DataLayer.DAOs.AssetDAO
import com.example.agdesk.DataLayer.DAOs.FieldDAO
import com.example.agdesk.DataLayer.DAOs.InventoryDAO
import com.example.agdesk.DataLayer.DAOs.DbSyncDAO
import com.example.agdesk.DataLayer.DAOs.TaskDAO
import com.example.agdesk.DataLayer.DAOs.UserDAO
import com.example.agdesk.DataLayer.database.AgDeskDatabase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AgDeskDatabase {
        return AgDeskDatabase.getDatabase(context)
    }


    @Provides
    @Singleton
    fun provideFeildDao(agDeskDatabase: AgDeskDatabase): FieldDAO {
        return agDeskDatabase.fieldDao()
    }

    @Provides
    @Singleton
    fun provideAssetDao(agDeskDatabase: AgDeskDatabase): AssetDAO {
        return agDeskDatabase.assetDao()
    }

    @Provides
    @Singleton
    fun provideTaskDao(agDeskDatabase: AgDeskDatabase): TaskDAO {
        return agDeskDatabase.taskDao()
    }

    @Provides
    @Singleton
    fun provideInventoryDao(agDeskDatabase: AgDeskDatabase): InventoryDAO {
        return agDeskDatabase.inventoryDao()
    }

    @Provides
    @Singleton
    fun provideUserDao(agDeskDatabase: AgDeskDatabase): UserDAO {
        return agDeskDatabase.userDao()
    }

    @Provides
    @Singleton
    fun provideSyncDao(agDeskDatabase: AgDeskDatabase): DbSyncDAO {
        return agDeskDatabase.dbSyncDao()
    }




}