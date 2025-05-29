package com.example.agdesk.models.UIModels

import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import com.example.agdesk.DataLayer.Converters.DatabaseConverter
import java.io.Serializable
import java.util.Date
import java.util.UUID

//Model to hold data for interaction with the UI layer and ViewModel
data class AssetModel(
    @field:TypeConverters(DatabaseConverter::class) val uid: UUID?, //unique ID for local storage
    @ColumnInfo(name = "asset_Prefix") val assetPrefix: String?, //differentiates between vehicles/equipment LV,HV,SE,LE
    @ColumnInfo(name = "asset_Name") val name: String?,
    @ColumnInfo(name = "manufacture") val manufac: String?,
    @ColumnInfo(name = "part_List") var parts: String?,
    @ColumnInfo(name = "location") var location: String?,
    @ColumnInfo(name = "date_Manufactured") val dateMade: Date?,
    @ColumnInfo(name = "date_Purchased") val dateBuy: Date?,
    @ColumnInfo(name = "asset_Image") val image: String?, //placeholder, no way to store image yet
    @ColumnInfo(name = "farm_Id") val farmId: Long?, //Id of farm this asset belongs to.
    @ColumnInfo(name = "vin") val vin: String?, //These three vals will be filled depending on the asset type
    @ColumnInfo(name = "serial_Number") val serialNo: String?,
    @ColumnInfo(name = "registration") val reg: String?,

    var checkoutStatus: Boolean?,// TO BE IMPLEMENTED
    var checkoutBy: String?, // TO BE IMPLEMENTED, will be a name of user who checked out
) : Serializable