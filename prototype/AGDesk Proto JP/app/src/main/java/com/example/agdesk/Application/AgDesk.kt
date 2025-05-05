package com.example.agdesk.Application


import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import com.example.agdesk.WorkManger.NetworkCheck
import com.example.agdesk.WorkManger.WorkManagerHelper
import dagger.hilt.android.HiltAndroidApp
import androidx.work.Configuration
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.agdesk.WorkManger.CustomWorkerFactory
import com.example.agdesk.WorkManger.SyncWorker
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import io.ktor.util.converters.DataConversion
import javax.inject.Inject


@HiltAndroidApp
class AgDesk: Application(), Configuration.Provider {



    @Inject
    lateinit var customWorkerFactory: CustomWorkerFactory




    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
            .setWorkerFactory(customWorkerFactory)
            .build()



    override fun onCreate() {
        super.onCreate()
        WorkManager.initialize(applicationContext, workManagerConfiguration)
        var networkCheck = NetworkCheck(applicationContext)
        networkCheck.startNetworkCallback()

    }



}
