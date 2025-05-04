package com.example.agdesk.networkComponents


import com.example.agdesk.models.networkModels.*
import com.example.agdesk.repository.AssetRepository
import com.example.agdesk.repository.TaskRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val assetRepository: AssetRepository,
                                            private val taskRepository: TaskRepository,
                                            private val httpClient: HttpClient) {

    suspend fun syncFromServer(lastSyncTimestamp: String) {
        try {
            val response: SyncResponse = httpClient.post("") {
                contentType(ContentType.Application.Json)
                setBody(SyncRequest(lastSyncTimestamp))
            }.body()

            // Save to local Room DB through your repositories
            assetRepository.updateAssetNetwork(response.assets)
            taskRepository.updateTaskNetwork(response.tasks)

        } catch (e: Exception) {
            e.printStackTrace()
            // Log or handle sync failure appropriately
        }
    }

    suspend fun syncToServer() {
        val assets = assetRepository.getOfflineAssets()
        val tasks = taskRepository.getOfflineTasks()

        val syncWrite = SyncWrite(assets, tasks)
        try {
            val response: SyncWrite = httpClient.post("") {
                contentType(ContentType.Application.Json)
                setBody(syncWrite)
            }.body()

            // Save to local Room DB through your repositories
            assetRepository.updateAssetNetwork(response.assets)
            taskRepository.updateTaskNetwork(response.tasks)

        } catch (e: Exception) {
            e.printStackTrace()
            // Log or handle sync failure appropriately
        }

    }





}