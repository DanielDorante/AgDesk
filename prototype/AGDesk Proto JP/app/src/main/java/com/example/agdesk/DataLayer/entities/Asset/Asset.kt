package com.example.agdesk.DataLayer.entities.Asset

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.agdesk.DataLayer.Converters.DatabaseConverter

@Entity
data class Asset(
    @PrimaryKey @field:TypeConverters(DatabaseConverter::class) val uid: String,
    @ColumnInfo(name = "asset_Prefix") val assetPrefix: String?,
    @ColumnInfo(name = "asset_Name") val name: String?,
    @ColumnInfo(name = "manufacture") val manufac: String?,
    @ColumnInfo(name = "part_List") val parts: String?,
    @ColumnInfo(name = "location") val location: String?,
    @ColumnInfo(name = "date_Manufactured") val dateMade: Long?,
    @ColumnInfo(name = "date_Purchased") val dateBuy: Long?,
    @ColumnInfo(name = "is_Delete") val isDel: Boolean,
    @ColumnInfo(name = "asset_Image") val image: String?,
    @ColumnInfo(name = "farm_Id") val farmId: Long?,
    @ColumnInfo(name = "global_Id") val syncId: Long?,
    )