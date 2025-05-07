package com.example.agdesk.models.UIModels

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.PrimaryKey
//Model to hold data for interaction with the UI layer and ViewModel
data class InventoryModel (
    @PrimaryKey val uid: String?,
    @ColumnInfo(name = "item_Name") val name: String?, //name
    @ColumnInfo(name = "stock_Keeping_Unit") var sku: String?, //barcode value
    @ColumnInfo(name = "category") val category: String?,
    @ColumnInfo(name = "quantity") var quantity: Int?,
    @ColumnInfo(name = "cost_Price") var costPrice: Double?,
    @ColumnInfo(name = "sell_Price") var salePrice: Double?,
    @Embedded val supplier: Supplier?,

)

data class Supplier(
    var name: String?,
    var email: String?,
    var phone: String?
)