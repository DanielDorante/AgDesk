package com.example.agdesk.models

data class AssetModel(
    var id: Int? = null,
    val assetPrefix: String? = null,
    val name: String? = null,
    val manufac: String? = null,
    val parts: String? = null,
    val location: String? = null,
    val dateMade: Int? = null,
    val dateBuy: Int? = null,
    val image: String? = null,
    val farmId: Int? = null,
    val vin: Int? = null,
    val serialNo: Int? = null,
    val reg: Int? = null,
    val syncId: Int? = null,
    var checkoutStatus: Boolean? = null,
    val checkoutBy: String? = null
)
