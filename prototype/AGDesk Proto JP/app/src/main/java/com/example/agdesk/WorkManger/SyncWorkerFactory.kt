package com.example.agdesk.WorkManger

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.example.agdesk.repository.NetworkRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import javax.inject.Inject

class SyncWorkerFactory @Inject constructor(
    private val networkRepository: NetworkRepository
) : WorkerFactory() {

    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParams: WorkerParameters
    ): ListenableWorker? {
        return if (workerClassName == SyncWorker::class.java.name) {
            SyncWorker(appContext, workerParams, networkRepository)
        } else {
            null
        }
    }
}