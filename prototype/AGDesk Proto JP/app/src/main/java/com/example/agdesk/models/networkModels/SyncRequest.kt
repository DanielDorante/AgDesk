package com.example.agdesk.models.networkModels

import kotlinx.serialization.Serializable

@Serializable
data class SyncRequest(
    val lastSyncTimeStamp: Long?

)
