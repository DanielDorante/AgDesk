package com.example.agdesk.models.networkModels

import com.example.agdesk.models.networkModels.dataModels.AssetNetworkModel
import com.example.agdesk.models.networkModels.dataModels.TaskNetworkModel
import kotlinx.serialization.Serializable

@Serializable
data class SyncResponse(
    val assets: List<AssetNetworkModel>,
    val tasks: List<TaskNetworkModel>

)
