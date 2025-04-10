package com.example.agdesk.models

import com.google.android.gms.maps.model.LatLng

data class FieldsModel(val name: String,
                       val userId: String,
                       val points: MutableList<LatLng>)
