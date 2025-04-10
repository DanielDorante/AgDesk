package com.example.agdesk.fragments

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.agdesk.R
import com.example.agdesk.database.DatabaseHelper
import com.example.agdesk.databinding.FragmentMapBinding
import com.example.agdesk.models.FieldsModel
import com.example.agdesk.models.HelperClass
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.Polygon
import com.google.android.gms.maps.model.PolygonOptions


class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!
    private val fieldsModelData = mutableListOf<FieldsModel>()
    private var check = ""
    private val fieldPoints = mutableListOf<LatLng>()
    private val currentFieldMarkers = mutableListOf<Marker>()
    private var currentPolygon: Polygon? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        clickListeners()
        return root
    }

    private fun clickListeners() {
        binding.fabAddField.setOnClickListener {
            showAddFieldDialog()
        }
        binding.ivFabCross.setOnClickListener {
            dismissFieldCreation()
        }
        binding.ivFabDone.setOnClickListener {
            finalizeFieldCreation()
        }
        binding.btnConfirmField.setOnClickListener {
            finalizeFieldCreation()
            if (check == "allow") {
                showNameFieldDialog()
            } else {
                Toast.makeText(
                    context, "You need at least 3 points to create a field.", Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    private fun showAddFieldDialog() {
        binding.fabAddField.setImageResource(R.drawable.ic_croos)
        val builder = AlertDialog.Builder(requireContext())
        val dialogView = layoutInflater.inflate(R.layout.add_field_dialog, null)
        builder.setView(dialogView)

        val dialog = builder.create()
        dialog.show()

        dialog.setOnDismissListener {
            binding.fabAddField.setImageResource(R.drawable.baseline_add_24)
        }

        dialogView.findViewById<Button>(R.id.btn_draw_field).setOnClickListener {
            dialog.dismiss()
            binding.btnConfirmField.visibility = View.VISIBLE
            binding.ivFabCross.visibility = View.VISIBLE
            binding.ivFabDone.visibility = View.VISIBLE
            Toast.makeText(context, "Tap the map to drop points", Toast.LENGTH_SHORT).show()

            // Allow the user to click on the map and add points
            googleMap.setOnMapClickListener { latLng ->
                addCustomMarker(latLng)
                fieldPoints.add(latLng)
            }
        }

        dialogView.findViewById<Button>(R.id.btn_drag_drop_field).setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun addCustomMarker(position: LatLng) {
        val markerOptions = MarkerOptions().position(position)
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker))
        val marker = googleMap.addMarker(markerOptions)

        marker?.let {
            currentFieldMarkers.add(it)
        }
    }
    private fun drawPolygon(field: FieldsModel) {
        val polygonOptions = PolygonOptions()
            .addAll(orderPointsForPolygon(field.points)) // Ensure correct point order
            .strokeWidth(5f)
            .strokeColor(resources.getColor(R.color.dark_main))
            .fillColor(resources.getColor(R.color.main))

        // Close the polygon by adding the first point again at the end
        polygonOptions.add(field.points.first())

        currentPolygon = googleMap.addPolygon(polygonOptions)
    }

    private fun orderPointsForPolygon(points: List<LatLng>): List<LatLng> {
        // Convex hull or other algorithm to order points
        // For simplicity, assuming points are already in the right order for now
        return points
    }

    private fun showNameFieldDialog() {
        val builder = AlertDialog.Builder(requireContext())
        val dialogView = layoutInflater.inflate(R.layout.dialog_name_field, null)
        builder.setView(dialogView)

        val dialog = builder.create()
        dialog.show()

        val fieldNameInput = dialogView.findViewById<EditText>(R.id.et_field_name)

        dialogView.findViewById<Button>(R.id.btn_save_field).setOnClickListener {
            val fieldName = fieldNameInput.text.toString()
            if (fieldName.isNotBlank()) {
                val field = FieldsModel(HelperClass.users?.id.toString(), fieldName, fieldPoints.toMutableList())
                fieldsModelData.add(field)

                val dbHelper = DatabaseHelper(requireContext())
                dbHelper.saveField(HelperClass.users?.id.toString(), fieldName, fieldPoints)

                val centroid = calculateCentroid(fieldPoints)
                showFieldNameInsidePolygon(fieldName, centroid)

                drawPolygon(field)
                Toast.makeText(requireContext(), "Field '$fieldName' created!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()

                googleMap.setOnMapClickListener(null)
                fieldPoints.clear()
                binding.btnConfirmField.visibility = View.GONE
                binding.ivFabCross.visibility = View.GONE
                binding.ivFabDone.visibility = View.GONE
            } else {
                Toast.makeText(requireContext(), "Field name can't be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun calculateCentroid(points: List<LatLng>): LatLng {
        var latitudeSum = 0.0
        var longitudeSum = 0.0

        for (point in points) {
            latitudeSum += point.latitude
            longitudeSum += point.longitude
        }

        val latitudeAvg = latitudeSum / points.size
        val longitudeAvg = longitudeSum / points.size

        return LatLng(latitudeAvg, longitudeAvg)
    }

    private fun showFieldNameInsidePolygon(fieldName: String, position: LatLng) {
        val fieldNameTextView = TextView(requireContext())
        fieldNameTextView.text = fieldName
        fieldNameTextView.setTextColor(Color.WHITE)
        fieldNameTextView.setBackgroundColor(Color.TRANSPARENT)
        fieldNameTextView.setPadding(10, 10, 10, 10)

        val layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )

        val projection = googleMap.projection
        val screenPosition = projection.toScreenLocation(position)

        layoutParams.leftMargin = screenPosition.x
        layoutParams.topMargin = screenPosition.y

        binding.mapContainer.addView(fieldNameTextView, layoutParams)
    }

    private fun dismissFieldCreation() {
        // Clear the markers added during this field creation session
        for (marker in currentFieldMarkers) {
            marker.remove()
        }
        currentFieldMarkers.clear()
        currentPolygon?.remove()
        currentPolygon = null
        fieldPoints.clear()

        binding.ivFabCross.visibility = View.GONE
        binding.ivFabDone.visibility = View.GONE
        binding.btnConfirmField.visibility = View.GONE

        googleMap.setOnMapClickListener(null)

        Toast.makeText(context, "Field creation canceled.", Toast.LENGTH_SHORT).show()
    }


    private fun finalizeFieldCreation() {
        if (fieldPoints.size < 3) {
            check = "notAllowed"
            Toast.makeText(context, "You need at least 3 points to create a field.", Toast.LENGTH_SHORT).show()
        } else {
            check = "allow"
            val tempField = FieldsModel(HelperClass.users?.id.toString(),"Unnamed Field", fieldPoints.toMutableList())
            drawPolygon(tempField)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        googleMap.mapType = GoogleMap.MAP_TYPE_SATELLITE

        // Load saved fields from the database
        val dbHelper = DatabaseHelper(requireContext())
        val savedFields = dbHelper.getFields(HelperClass.users?.id.toString())

        for (field in savedFields) {
            fieldsModelData.add(field)
            drawPolygon(field)
            val centroid = calculateCentroid(field.points)
            showFieldNameInsidePolygon(field.name, centroid)
        }
        googleMap.setOnCameraMoveListener {
            for (field in fieldsModelData) {
                val centroid = calculateCentroid(field.points)
                updateFieldNamePosition(field.name, centroid)
            }
        }
    }
    // Method to update the position of the TextView displaying the field name
    private fun updateFieldNamePosition(fieldName: String, position: LatLng) {
        val mapContainer = binding.mapContainer
        val childCount = mapContainer.childCount
        for (i in 0 until childCount) {
            val view = mapContainer.getChildAt(i)
            if (view is TextView && view.text == fieldName) {
                val projection = googleMap.projection
                val screenPosition = projection.toScreenLocation(position)
                val layoutParams = view.layoutParams as FrameLayout.LayoutParams
                layoutParams.leftMargin = screenPosition.x
                layoutParams.topMargin = screenPosition.y
                view.layoutParams = layoutParams
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
