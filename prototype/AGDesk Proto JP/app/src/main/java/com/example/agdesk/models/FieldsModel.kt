package com.example.agdesk.models

import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import com.example.agdesk.DataLayer.Converters.DatabaseConverter
import com.google.android.gms.maps.model.LatLng

data class FieldsModel (
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "points")@field:TypeConverters(DatabaseConverter::class) val points: MutableList<LatLng>)
