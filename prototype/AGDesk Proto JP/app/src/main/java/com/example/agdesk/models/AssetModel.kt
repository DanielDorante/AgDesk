package com.example.agdesk.models

import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import com.example.agdesk.DataLayer.Converters.DatabaseConverter
import org.jetbrains.annotations.ApiStatus
import java.util.UUID

//Model to hold data for interaction with the UI layer and ViewModel/ Maybe network repository
data class AssetModel(
    @field:TypeConverters(DatabaseConverter::class) var uid: UUID?, //unique ID for local storage
    @ColumnInfo(name = "asset_Prefix") val assetPrefix: String?, //differentiates between vehicles/equipment LV,HV,SE,LE
    @ColumnInfo(name = "asset_Name") val name: String?,
    @ColumnInfo(name = "manufacture") val manufac: String?,
    @ColumnInfo(name = "part_List") val parts: String?,
    @ColumnInfo(name = "location") val location: String?,
    @ColumnInfo(name = "date_Manufactured") val dateMade: Int?,
    @ColumnInfo(name = "date_Purchased") val dateBuy: Int?,
    @ColumnInfo(name = "asset_Image") val image: String?,
    @ColumnInfo(name = "farm_Id") val farmId: Int?, //Id of farm this asset belongs to.
    @ColumnInfo(name = "vin") val vin: Int?, //These three vals will be filled depending on the asset type
    @ColumnInfo(name = "serial_Number") val serialNo: Int?,
    @ColumnInfo(name = "registration") val reg: Int?,
    @ColumnInfo(name = "global_Id") val syncId: Int?, //incremented Id from the master database. used for syncing purposes
    var checkoutStatus: Boolean?,// TO BE IMPLEMENTED
    var checkoutBy: String?, // TO BE IMPLEMENTED, will be a name of user who checked out
    )
