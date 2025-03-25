package com.example.agdesk.DataLayer.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey




@Entity
data class InventoryItem(
    @PrimaryKey val uid: String,
    @ColumnInfo(name = "item_Name") val name: String?,
    @ColumnInfo(name = "stock_Keeping_Unit") val sku: Int?,
    @ColumnInfo(name = "category") val category: String?,
    @ColumnInfo(name = "quantity") val quantity: String?,
    @ColumnInfo(name = "cost_Price") val costPrice: Double?,
    @ColumnInfo(name = "sell_Price") val salePrice: Double?,
    @Embedded val supplier: Supplier?,
    @ColumnInfo(name = "global_Id") val syncid: Int?,




    )

data class Supplier(
    val name: String?,
    val email: String?,
    val phone: Int?
)