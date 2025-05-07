package com.example.agdesk.models.UIModels

import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import com.example.agdesk.DataLayer.Converters.DatabaseConverter
import com.google.android.gms.maps.model.LatLng

//Model to hold data for interaction with the UI layer and ViewModel
data class FieldsModel ( //Needs id and repository rework for full CRUD
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "points")@field:TypeConverters(DatabaseConverter::class) val points: MutableList<LatLng>)