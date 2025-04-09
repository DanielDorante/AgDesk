package com.example.agdesk.fragments

import com.example.agdesk.database.DatabaseHelper
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
import com.example.agdesk.models.FieldsModel
import com.example.agdesk.R
import com.example.agdesk.databinding.FragmentMapBinding
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

    // Reference to GoogleMap object for map operations
    private lateinit var googleMap: GoogleMap

    // Binding to handle the fragment's layout efficiently
    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding!!  // Getter for safe access to the binding

    // Stores fields data (name and points)
    private val fieldsModelData = mutableListOf<FieldsModel>()

    // Check variable to validate field creation
    private var check = ""

    // Stores the points of a field while creating it
    private val fieldPoints = mutableListOf<LatLng>()

    // Keeps track of markers added on the map during field creation
    private val currentFieldMarkers = mutableListOf<Marker>()

    // Holds the polygon that represents the field
    private var currentPolygon: Polygon? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout and bind it to the fragment
        _binding = FragmentMapBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Get the map fragment from the layout and set the map ready callback
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Set up listeners for user actions
        clickListeners()

        return root
    }

    // Defines click listeners for UI components
    private fun clickListeners() {
        // Start the field creation process when the "Add Field" button is clicked
        binding.fabAddField.setOnClickListener {
            showAddFieldDialog()  // Show dialog to choose field creation method
        }

        // Cancel field creation process
        binding.ivFabCross.setOnClickListener {
            dismissFieldCreation()
        }

        // Finalize field creation by drawing the field
        binding.ivFabDone.setOnClickListener {
            finalizeFieldCreation()
        }

        // Confirm the field creation process when the confirm button is clicked
        binding.btnConfirmField.setOnClickListener {
            finalizeFieldCreation()
            if (check == "allow") {
                showNameFieldDialog()  // Ask user to name the field
            } else {
                Toast.makeText(
                    context, "You need at least 3 points to create a field.", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    // Displays a dialog that allows the user to choose how to add a field
    private fun showAddFieldDialog() {
        binding.fabAddField.setImageResource(R.drawable.ic_croos)  // Change FAB icon

        // Build and show the dialog
        val builder = AlertDialog.Builder(requireContext())
        val dialogView = layoutInflater.inflate(R.layout.add_field_dialog, null)
        builder.setView(dialogView)
        val dialog = builder.create()
        dialog.show()

        // Restore the FAB icon when the dialog is dismissed
        dialog.setOnDismissListener {
            binding.fabAddField.setImageResource(R.drawable.baseline_add_24)
        }

        // Add field by dropping points on the map
        dialogView.findViewById<Button>(R.id.btn_draw_field).setOnClickListener {
            dialog.dismiss()
            binding.btnConfirmField.visibility = View.VISIBLE
            binding.ivFabCross.visibility = View.VISIBLE
            binding.ivFabDone.visibility = View.VISIBLE
            Toast.makeText(context, "Tap the map to drop points", Toast.LENGTH_SHORT).show()

            // Allow the user to drop points on the map to create a field
            googleMap.setOnMapClickListener { latLng ->
                addCustomMarker(latLng)  // Add marker at clicked position
                fieldPoints.add(latLng)  // Add the point to the field's point list
            }
        }

        // Drag and drop field creation (not implemented here)
        dialogView.findViewById<Button>(R.id.btn_drag_drop_field).setOnClickListener {
            dialog.dismiss()
        }
    }

    // Adds a custom marker to the map at the given position
    private fun addCustomMarker(position: LatLng) {
        val markerOptions = MarkerOptions().position(position)
            .icon(BitmapDescriptorFactory.fromResource(R.drawable.map_marker))  // Custom marker icon
        val marker = googleMap.addMarker(markerOptions)

        marker?.let {
            currentFieldMarkers.add(it)  // Store the marker for future reference
        }
    }

    // Draws a polygon representing the field on the map
    private fun drawPolygon(field: FieldsModel) {
        val polygonOptions = PolygonOptions()
            .addAll(orderPointsForPolygon(field.points))  // Ensure correct order of points
            .strokeWidth(5f)
            .strokeColor(resources.getColor(R.color.dark_main))  // Polygon border color
            .fillColor(resources.getColor(R.color.main))  // Polygon fill color

        // Close the polygon by connecting the last point to the first
        polygonOptions.add(field.points.first())
        currentPolygon = googleMap.addPolygon(polygonOptions)
    }

    // Orders points for polygon creation (can use algorithms like convex hull)
    private fun orderPointsForPolygon(points: List<LatLng>): List<LatLng> {
        // For simplicity, assuming points are already in the right order
        return points
    }

    // Shows a dialog to allow the user to name the created field
    private fun showNameFieldDialog() {
        val builder = AlertDialog.Builder(requireContext())
        val dialogView = layoutInflater.inflate(R.layout.dialog_name_field, null)
        builder.setView(dialogView)

        val dialog = builder.create()
        dialog.show()

        // Retrieve the field name from the user input
        val fieldNameInput = dialogView.findViewById<EditText>(R.id.et_field_name)

        dialogView.findViewById<Button>(R.id.btn_save_field).setOnClickListener {
            val fieldName = fieldNameInput.text.toString()
            if (fieldName.isNotBlank()) {
                // Save the field data and update the UI
                val field = FieldsModel(fieldName, fieldPoints.toMutableList())
                fieldsModelData.add(field)

                val dbHelper = DatabaseHelper(requireContext())
                dbHelper.saveField(fieldName, fieldPoints)  // Save field to database

                val centroid = calculateCentroid(fieldPoints)  // Calculate the centroid of the polygon
                showFieldNameInsidePolygon(fieldName, centroid)  // Show the field name inside the polygon

                drawPolygon(field)  // Draw the polygon on the map
                Toast.makeText(requireContext(), "Field '$fieldName' created!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()

                googleMap.setOnMapClickListener(null)  // Disable further map clicks
                fieldPoints.clear()  // Clear points for next field creation
                binding.btnConfirmField.visibility = View.GONE
                binding.ivFabCross.visibility = View.GONE
                binding.ivFabDone.visibility = View.GONE
            } else {
                Toast.makeText(requireContext(), "Field name can't be empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Calculates the centroid (geometric center) of the field points
    private fun calculateCentroid(points: List<LatLng>): LatLng {
        var latitudeSum = 0.0
        var longitudeSum = 0.0

        for (point in points) {
            latitudeSum += point.latitude
            longitudeSum += point.longitude
        }

        // Calculate the average latitude and longitude
        val latitudeAvg = latitudeSum / points.size
        val longitudeAvg = longitudeSum / points.size

        return LatLng(latitudeAvg, longitudeAvg)
    }

    // Adds a TextView with the field's name inside the polygon
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

        // Get screen position of the centroid for displaying field name
        val projection = googleMap.projection
        val screenPosition = projection.toScreenLocation(position)

        layoutParams.leftMargin = screenPosition.x
        layoutParams.topMargin = screenPosition.y

        // Add the field name TextView to the map container
        binding.mapContainer.addView(fieldNameTextView, layoutParams)
    }

    // Cancels the current field creation process
    private fun dismissFieldCreation() {
        // Remove all markers from the map
        for (marker in currentFieldMarkers) {
            marker.remove()
        }
        currentFieldMarkers.clear()
        currentPolygon?.remove()  // Remove the polygon
        currentPolygon = null
        fieldPoints.clear()  // Clear points

        binding.ivFabCross.visibility = View.GONE
        binding.ivFabDone.visibility = View.GONE
        binding.btnConfirmField.visibility = View.GONE

        googleMap.setOnMapClickListener(null)  // Disable map clicks

        Toast.makeText(context, "Field creation canceled.", Toast.LENGTH_SHORT).show()
    }

    // Finalizes the field creation process and checks if at least 3 points were added
    private fun finalizeFieldCreation() {
        if (fieldPoints.size < 3) {
            check = "notAllowed"
            Toast.makeText(context, "You need at least 3 points to create a field.", Toast.LENGTH_SHORT).show()
        } else {
            check = "allow"
            val tempField = FieldsModel("Unnamed Field", fieldPoints.toMutableList())
            drawPolygon(tempField)  // Draw the field as a polygon
        }
    }

    // Called when the map is ready to be used
    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        googleMap.mapType = GoogleMap.MAP_TYPE_SATELLITE  // Set the map type to satellite

        // Load fields previously saved in the database
        val dbHelper = DatabaseHelper(requireContext())
        val savedFields = dbHelper.getFields()

        // Draw each saved field on the map
        for (field in savedFields) {
            fieldsModelData.add(field)
            drawPolygon(field)  // Draw polygon for each field
            val centroid = calculateCentroid(field.points)
            showFieldNameInsidePolygon(field.name, centroid)  // Display field name inside polygon
        }

        // Update the position of field names when the map moves
        googleMap.setOnCameraMoveListener {
            for (field in fieldsModelData) {
                val centroid = calculateCentroid(field.points)
                updateFieldNamePosition(field.name, centroid)
            }
        }
    }

    // Updates the position of the TextView displaying the field name when the map moves
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
                view.layoutParams = layoutParams  // Update the field name position
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null  // Clean up binding reference when the view is destroyed
    }
}

