package com.example.agdesk.models.networkModels.dataModels

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
data class ExpenseNetworkModel(
    @PrimaryKey @ColumnInfo(name = "Expense_id") val uid: String,
    @ColumnInfo(name = "Global_id") val syncId: Int?,
    @ColumnInfo(name = "Cost") val start: Int,
    @ColumnInfo(name = "receipt_Number") val receipt: Int,
    @ColumnInfo(name = "is_Delete") val isDelete: Boolean?,
    @ColumnInfo(name = "Maintenance_Id") val maintenanceId: String,
    @ColumnInfo(name = "Asset_Id") val assetId: String,
    @ColumnInfo(name = "Lodged_by_id") val lodgedById: Int,
)
