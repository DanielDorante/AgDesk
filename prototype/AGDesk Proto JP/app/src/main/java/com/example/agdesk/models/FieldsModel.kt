package com.example.agdesk.models

import com.google.android.gms.maps.model.LatLng

data class FieldsModel (val name: String, val points: MutableList<LatLng>)
