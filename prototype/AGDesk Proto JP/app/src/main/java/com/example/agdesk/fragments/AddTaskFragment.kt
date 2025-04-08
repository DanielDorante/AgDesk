package com.example.agdesk.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.agdesk.R
import com.example.agdesk.DataLayer.database.DatabaseHelper
import com.example.agdesk.databinding.FragmentAddTaskBinding
import com.example.agdesk.models.TaskModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddTaskFragment : Fragment() {
    var binding: FragmentAddTaskBinding? = null
    var name: String? = ""
    var date: String? = ""
    var time: String? = ""
    var startTime: Calendar? = null
    var endTime: Calendar? = null
    var dbHelper : DatabaseHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddTaskBinding.inflate(layoutInflater)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dbHelper = DatabaseHelper(requireContext())
        binding?.ivBack?.setOnClickListener { findNavController().navigateUp() }
        binding?.btnAddNow?.setOnClickListener {
            if (isValidated()) {
                dbHelper?.addTask(name ?: "", date ?: "", time ?: "")
                showMessage("Task added successfully")
                findNavController().navigateUp()
            }
        }

        binding?.etChooseDate?.setOnClickListener {
            selectDate()
        }

        binding?.etChooseTime?.setOnClickListener {
            selectTime()
        }

    }

    private fun isValidated(): Boolean {
        name = binding?.etName?.text.toString().trim()
        date = binding?.etChooseDate?.text.toString().trim()
        time = binding?.etChooseTime?.text.toString().trim()


        if (name?.isEmpty() == true) {
            showMessage("Please enter name")
            return false
        }

        if (date?.isEmpty() == true) {
            showMessage("Please select date")
            return false
        }

        if (time?.isEmpty() == true) {
            showMessage("Please select time")
            return false
        }

        // Check if startTime is set and is before endTime
        if (startTime != null && endTime != null && startTime!!.after(endTime)) {
            showMessage("Start time cannot be later than end time")
            return false
        }

        return true
    }

    // Select date method
    private fun selectDate() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                val selectedDate = Calendar.getInstance()
                selectedDate.set(year, month, dayOfMonth)
                val format = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                binding?.etChooseDate?.setText(format.format(selectedDate.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    // Select start and end time method
    private fun selectTime() {
        val calendar = Calendar.getInstance()

        // Time format for AM/PM
        val timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())

        // Show the first TimePicker for start time
        TimePickerDialog(
            requireContext(),
            { _, startHour, startMinute ->
                startTime = Calendar.getInstance()
                startTime?.set(Calendar.HOUR_OF_DAY, startHour)
                startTime?.set(Calendar.MINUTE, startMinute)

                // After selecting start time, show the second TimePicker for end time
                TimePickerDialog(
                    requireContext(),
                    { _, endHour, endMinute ->
                        endTime = Calendar.getInstance()
                        endTime?.set(Calendar.HOUR_OF_DAY, endHour)
                        endTime?.set(Calendar.MINUTE, endMinute)

                        // Set the time range to etChooseTime
                        val formattedStartTime = timeFormat.format(startTime?.time)
                        val formattedEndTime = timeFormat.format(endTime?.time)
                        binding?.etChooseTime?.setText("$formattedStartTime - $formattedEndTime")
                    },
                    calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    false // use 12-hour format
                ).show()
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false // use 12-hour format
        ).show()
    }


    private fun showMessage(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }


}