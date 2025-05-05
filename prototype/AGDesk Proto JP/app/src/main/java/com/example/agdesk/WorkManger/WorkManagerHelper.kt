package com.example.agdesk.WorkManger

import android.content.Context
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.agdesk.WorkManger.SyncWorker
import java.util.concurrent.TimeUnit


object WorkManagerHelper {

    // Schedule periodic sync every hour (or as needed)
    fun scheduleSyncWork(context: Context) {
        val constraints = androidx.work.Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED) // Requires internet connectivity
            .build()

        val syncRequest = PeriodicWorkRequestBuilder<SyncWorker>(1, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()

        // Enqueue the periodic work
        WorkManager.getInstance(context).enqueue(syncRequest)
    }

    // Trigger immediate sync when the network is available
    fun triggerImmediateSync(context: Context) {
        val constraints = androidx.work.Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED) // Requires internet connectivity
            .build()

        val syncRequest = OneTimeWorkRequestBuilder<SyncWorker>()
            .setConstraints(constraints)
            .build()

        // Enqueue the immediate sync work
        WorkManager.getInstance(context).enqueue(syncRequest)
    }
}