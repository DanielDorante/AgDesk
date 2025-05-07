package com.example.agdesk.models.networkModels.dataModels

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
data class OperationNetworkModel(
    @PrimaryKey @ColumnInfo(name = "Log_id") val uid: String,
    @ColumnInfo(name = "Global_id") val syncId: Int?,
    @ColumnInfo(name = "Start_Date_Time") val start: String,
    @ColumnInfo(name = "End_Date_Time") val end: String?,
    @ColumnInfo(name = "Location") val location: String,
    @ColumnInfo(name = "Notes") val notes: String?,
    @ColumnInfo(name = "isDelete") val isDelete: Boolean,
    @ColumnInfo(name = "Asset_Id") val assetUid: String,
    @ColumnInfo(name = "User_ID") val userid: String,
)
