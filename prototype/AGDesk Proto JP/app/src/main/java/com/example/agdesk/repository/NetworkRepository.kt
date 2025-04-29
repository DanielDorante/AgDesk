package com.example.agdesk.repository
import com.example.agdesk.repository.AssetRepository
import com.example.agdesk.repository.TaskRepository
import javax.inject.Inject

class NetworkRepository @Inject constructor (taskRepository: TaskRepository, assetRepository: AssetRepository){

    suspend fun offlinesyncgen(): String {

    }

}