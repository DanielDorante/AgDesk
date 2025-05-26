package com.example.agdesk.DomainLayer.repository



import com.example.agdesk.DataLayer.DAOs.DbSyncDAO
import com.example.agdesk.DataLayer.entities.sync.DbSync
import com.example.agdesk.models.networkModels.*
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.http.*
import java.util.Date
import javax.inject.Inject

class NetworkRepository @Inject constructor(private val assetRepository: AssetRepository,
                                            private val taskRepository: TaskRepository,
                                            private val httpClient: HttpClient,
                                            private val dbSyncDAO: DbSyncDAO) {

    suspend fun syncFromServer() {



        try {
            val response: SyncResponse = httpClient.post("https://run.mocky.io/v3/ebb5653a-17d0-413b-900e-5170aac21f7c") {
                contentType(ContentType.Application.Json)
                setBody(dbSyncDAO.getLastSyncInfo())
            }.body()

            // Save to local Room DB through your repositories
            assetRepository.updateAssetNetwork(response.assets)
            taskRepository.updateTaskNetwork(response.tasks)
            dbSyncDAO.insertSyncInfo(DbSync(1, System.currentTimeMillis()))

        } catch (e: Exception) {
            e.printStackTrace()
            // Log or handle sync failure appropriately
        }
    }

    suspend fun getSyncTimeUI(): Date {
        val time = dbSyncDAO.getLastSyncInfo()?.lastSyncTimeStamp
        if (time == null) {
            return Date(0)
        }
        return Date(time)

    }

    suspend fun syncToServer() {
        val assets = assetRepository.getOfflineAssets()
        val tasks = taskRepository.getOfflineTasks()

        val syncWrite = SyncWrite(assets, tasks)
        try {
            val response: SyncWrite = httpClient.post("https://run.mocky.io/v3/72280e67-2d66-489f-8ffa-9fa6b21856a6") {
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