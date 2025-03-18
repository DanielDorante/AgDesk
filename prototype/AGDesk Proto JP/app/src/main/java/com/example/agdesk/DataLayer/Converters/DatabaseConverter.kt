package com.example.agdesk.DataLayer.Converters

import android.util.Log
import androidx.room.TypeConverter
import com.example.agdesk.models.FieldsModel
import com.google.android.gms.maps.model.LatLng
import kotlinx.serialization.json.Json


class DatabaseConverter {


    @TypeConverter
    public fun fromLatLng(latLngList: List<LatLng>): String{
        val lat = latLngList.joinToString(";") { "${it.latitude},${it.longitude}" }
        return lat

    }

    @TypeConverter
    public fun toLatLng(latLngList: String): MutableList<LatLng>{



                val points = latLngList.split(";").map {
                    val latLng = it.split(",")
                    LatLng(latLng[0].toDouble(), latLng[1].toDouble())
                }
               return points.toMutableList()


    }


}