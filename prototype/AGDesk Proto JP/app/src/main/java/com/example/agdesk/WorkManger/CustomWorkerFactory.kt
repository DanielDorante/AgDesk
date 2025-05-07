package com.example.agdesk.WorkManger

import android.content.Context
import androidx.work.ListenableWorker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
import com.example.agdesk.DomainLayer.repository.NetworkRepository
import javax.inject.Inject

class CustomWorkerFactory @Inject constructor(
    private val networkRepository: NetworkRepository,
) : WorkerFactory() {
    override fun createWorker(
        appContext: Context,
        workerClassName: String,
        workerParameters: WorkerParameters
    ): ListenableWorker? {
        return when (workerClassName) {
            SyncWorker::class.java.name -> SyncWorker(
                appContext,
                workerParameters,
                networkRepository
            )
            //other could come here, or directly return single one
            else -> null
        }
    }
}