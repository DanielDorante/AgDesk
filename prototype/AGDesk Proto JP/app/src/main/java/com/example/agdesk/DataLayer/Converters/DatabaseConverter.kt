package com.example.agdesk.DataLayer.Converters

import androidx.room.TypeConverter
import com.google.android.gms.maps.model.LatLng
import java.util.UUID
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


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


    @TypeConverter
    public fun fromUUID(uuid: UUID): String {
            return uuid.toString()
    }

    @TypeConverter
    public fun uuidFromString(string: String): UUID {
            return UUID.fromString(string)
    }

    @TypeConverter
    public fun fromUnix(timestamp: Int): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val date = Date(timestamp.toLong())
        return sdf.format(date)
    }

    //@TypeConverter
    //public fun dateToUnix(string: String): UUID {
    //    return UUID.fromString(string)
   // }




}