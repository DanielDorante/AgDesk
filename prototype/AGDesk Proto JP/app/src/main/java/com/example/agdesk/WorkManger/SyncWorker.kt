package com.example.agdesk.WorkManger

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.agdesk.repository.NetworkRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import androidx.work.CoroutineWorker
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltWorker
class SyncWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val networkRepository: NetworkRepository
) : CoroutineWorker(appContext, workerParams) {

    // No need for manual coroutine scope, since CoroutineWorker supports suspending functions directly.
    override suspend fun doWork(): Result {
        return try {
            // Call the suspend function
            networkRepository.syncToServer()
            networkRepository.syncFromServer() // Perform the sync

            Result.success() // Return success if sync is done
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure() // Return failure if there was an error
        }
    }
}
