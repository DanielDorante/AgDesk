package com.example.agdesk.models

import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import com.example.agdesk.DataLayer.Converters.DatabaseConverter
import java.util.UUID


data class AssetModel(
    @field:TypeConverters(DatabaseConverter::class) var uid: UUID?,
    @ColumnInfo(name = "asset_Prefix") val assetPrefix: String?,
    @ColumnInfo(name = "asset_Name") val name: String?,
    @ColumnInfo(name = "manufacture") val manufac: String?,
    @ColumnInfo(name = "part_List") val parts: String?,
    @ColumnInfo(name = "location") val location: String?,
    @ColumnInfo(name = "date_Manufactured") val dateMade: Int?,
    @ColumnInfo(name = "date_Purchased") val dateBuy: Int?,
    @ColumnInfo(name = "asset_Image") val image: String?,
    @ColumnInfo(name = "farm_Id") val farmId: Int?,
    @ColumnInfo(name = "vin") val vin: Int?,
    @ColumnInfo(name = "serial_Number") val serialNo: Int?,
    @ColumnInfo(name = "registration") val reg: Int?,
    @ColumnInfo(name = "global_Id") val syncId: Int?,
    ) {
    init {
        if (uid == null) {
            uid = UUID.randomUUID()
        }
    }
}
