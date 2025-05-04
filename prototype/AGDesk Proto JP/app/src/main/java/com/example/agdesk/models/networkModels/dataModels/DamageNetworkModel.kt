package com.example.agdesk.models.networkModels.dataModels

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class DamageNetworkModel(
    @PrimaryKey @ColumnInfo(name = "Damage_Id") val uid: String,
    @ColumnInfo(name = "Global_id") val syncId: Int?,
    @ColumnInfo(name = "Damage_Observed_Date") val damageObservedDate: String,
    @ColumnInfo(name = "Damage_Occurred_Date") val damageOccurredDate: String,
    @ColumnInfo(name = "Damage_Type") val damageType: String,
    @ColumnInfo(name = "Damage_Severity") val damageSeverity: String,
    @ColumnInfo(name = "Notes") val notes: String,
    @ColumnInfo(name = "Damage_Image") val damageImage: String?,
    @ColumnInfo(name = "Scheduled_Maintenance_Date") val scheduleMaintenanceDate: Int?,
    @ColumnInfo(name = "Is_Delete") val isDelete: Boolean?,
    @ColumnInfo(name = "Asset_Id") val assetId: String,
)
