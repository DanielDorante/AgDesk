package com.example.agdesk.Application

import com.example.agdesk.WorkManger.SyncWorkerFactory
import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import com.example.agdesk.WorkManger.NetworkCheck
import com.example.agdesk.WorkManger.WorkManagerHelper
import dagger.hilt.android.HiltAndroidApp
import androidx.work.Configuration
import androidx.work.WorkManager
import com.example.agdesk.WorkManger.SyncWorker
import io.ktor.util.converters.DataConversion
import javax.inject.Inject


@HiltAndroidApp
class AgDesk: Application(), Configuration.Provider {

    @Inject
    lateinit var hiltWorkerFactory: HiltWorkerFactory


    override fun onCreate() {
        super.onCreate()
        WorkManagerHelper.scheduleSyncWork(applicationContext)
        val networkCheck = NetworkCheck(applicationContext, WorkManagerHelper)
        networkCheck.startNetworkCallback()
        // Optionally, schedule the sync work when the app starts

    }

    override fun getWorkManagerConfiguration(): Configuration {
        val workManagerConfig = Configuration.Builder()
            .setWorkerFactory(hiltWorkerFactory)
            .build()
        return workManagerConfig
    }
}
