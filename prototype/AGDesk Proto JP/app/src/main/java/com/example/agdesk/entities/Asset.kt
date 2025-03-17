package com.example.agdesk.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Asset(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "asset_Prefix") val assetPrefix: String?,
    @ColumnInfo(name = "asset_Name") val name: String?,
    @ColumnInfo(name = "manufacture") val manufac: String?,
    @ColumnInfo(name = "part_List") val parts: String?,
    @ColumnInfo(name = "location") val location: String?,
    @ColumnInfo(name = "date_Manufactured") val dateMade: Int?,
    @ColumnInfo(name = "date_Purchased") val dateBuy: Int?,
    @ColumnInfo(name = "is_Delete") val isDel: Boolean,
    @ColumnInfo(name = "asset_Image") val image: String?,
    @ColumnInfo(name = "farm_Id") val farmId: Int?,
    @ColumnInfo(name = "global_Id") val syncId: Int?,
    )