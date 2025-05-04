package com.example.agdesk.networkComponents
import com.example.agdesk.models.networkModels.*


interface ApiInterface {
    fun syncItems(timestamp: String): SyncResponse
}