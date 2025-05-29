package com.example.agdesk.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.agdesk.R
import com.example.agdesk.ViewModels.TaskViewModel
import com.example.agdesk.database.DatabaseHelper
import com.example.agdesk.databinding.FragmentAddTaskBinding
import com.example.agdesk.models.HelperClass
import com.example.agdesk.models.UIModels.TaskModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.UUID
import kotlin.getValue

@AndroidEntryPoint
class AddTaskFragment : Fragment() {
    var binding: FragmentAddTaskBinding? = null
    var name: String? = ""
    var description: String? = ""
    var startTime: Calendar? = null
    var endTime: Calendar? = null
    var dueDateCalendar: Calendar? = null
    var expiryDateCalendar: Calendar? = null
    var status: Int? = null
    var priority: Int? = null
    var assignedId: Long? = null
    var assignedName: String? = ""
    var farmId: Long? = null
    var dbHelper : DatabaseHelper? = null
    private val taskViewModel: TaskViewModel by viewModels()

    // Track whether we're editing an existing task
    private var isEditMode = false
    private var existingTask: TaskModel? = null

    // Status and priority labels
    private val statusLabels = arrayOf("Not Started", "In Progress", "Blocked", "Completed", "Failed", "Cancelled")
    private val priorityLabels = arrayOf("Low", "Medium", "High", "Critical")

    companion object {
        const val ARG_TASK = "task"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { args ->
            if (args.containsKey(ARG_TASK)) {
                existingTask = args.getSerializable(ARG_TASK) as? TaskModel
                isEditMode = existingTask != null
            }
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

        // Set up status spinner
        val statusAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            statusLabels
        )
        statusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding?.spinnerStatus?.adapter = statusAdapter

        // Set up priority spinner
        val priorityAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            priorityLabels
        )
        priorityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding?.spinnerPriority?.adapter = priorityAdapter

        binding?.ivBack?.setOnClickListener { findNavController().navigateUp() }

        binding?.etDueDate?.setOnClickListener {
            selectDueDate()
        }

        binding?.etExpiryDate?.setOnClickListener {
            selectExpiryDate()
        }

        // Update UI based on mode (add or edit)
        setupUI()

        binding?.btnAddNow?.setOnClickListener {
            if (isValidated()) {
                saveTask()
            }
        }
    }

    private fun setupUI() {
        if (isEditMode) {
            // Set title for edit mode
            binding?.tvTitle?.text = "Edit Task"
            binding?.btnAddNow?.text = "Update"

            // Populate fields with existing task data
            existingTask?.let { task ->
                binding?.etName?.setText(task.name)
                binding?.etDescription?.setText(task.desc)

                // Set due date if available
                task.due?.let { dueDate ->
                    val calendar = Calendar.getInstance()
                    calendar.time = dueDate
                    dueDateCalendar = calendar
                    val format = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                    binding?.etDueDate?.setText(format.format(dueDate))
                }

                // Set expiry date if available
                task.exp?.let { expiryDate ->
                    val calendar = Calendar.getInstance()
                    calendar.time = expiryDate
                    expiryDateCalendar = calendar
                    val format = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                    binding?.etExpiryDate?.setText(format.format(expiryDate))
                }

                // Set status if available
                task.status?.let { statusValue ->
                    binding?.spinnerStatus?.setSelection(statusValue)
                }

                // Set priority if available
                task.priority?.let { priorityValue ->
                    binding?.spinnerPriority?.setSelection(priorityValue)
                }

                // Set assigned information if available
                binding?.etAssignedId?.setText(task.assignedId?.toString() ?: "")
                binding?.etAssignedName?.setText(task.assigned ?: "")

                // Set farm ID if available
                binding?.etFarmId?.setText(task.farm?.toString() ?: "")
            }
        } else {
            binding?.tvTitle?.text = "Add Task"
            binding?.btnAddNow?.text = "Add Now"
        }
    }

    private fun saveTask() {
        // Convert the date strings to Date objects
        val dueDate = if (!binding?.etDueDate?.text.isNullOrEmpty()) {
            SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).parse(binding?.etDueDate?.text.toString())
        } else null

        val expiryDate = if (!binding?.etExpiryDate?.text.isNullOrEmpty()) {
            SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).parse(binding?.etExpiryDate?.text.toString())
        } else null

        if (isEditMode) {
            // Update existing task
            existingTask?.let { task ->
                val updatedTask = task.copy(
                    name = name,
                    desc = description,
                    due = dueDate,
                    exp = expiryDate,
                    status = status,
                    priority = priority,
                    assignedId = assignedId,
                    assigned = assignedName,
                    farm = farmId
                )
                taskViewModel.updateTask(updatedTask)
                showMessage("Task updated successfully")
            }
        } else {
            // Create new task
            taskViewModel.insertTasks(TaskModel(
                uid = UUID.randomUUID(),
                name = name,
                desc = description,
                timestamp = Date(), // Auto-set the timestamp on creation
                del = false,
                due = dueDate,
                exp = expiryDate,
                status = status,
                priority = priority,
                assignedId = assignedId,
                assigned = assignedName,
                farm = farmId,
            ))
            showMessage("Task added successfully")
        }
        findNavController().navigateUp()
    }

    private fun isValidated(): Boolean {
        name = binding?.etName?.text.toString().trim()
        description = binding?.etDescription?.text.toString().trim()

        status = binding?.spinnerStatus?.selectedItemPosition
        priority = binding?.spinnerPriority?.selectedItemPosition

        val assignedIdText = binding?.etAssignedId?.text.toString().trim()
        assignedId = if (assignedIdText.isNotEmpty()) assignedIdText.toLongOrNull() else null

        assignedName = binding?.etAssignedName?.text.toString().trim()

        val farmIdText = binding?.etFarmId?.text.toString().trim()
        farmId = if (farmIdText.isNotEmpty()) farmIdText.toLongOrNull() else null

        if (name?.isEmpty() == true) {
            showMessage("Please enter name")
            return false
        }

        if (description?.isEmpty() == true) {
            showMessage("Please enter description")
            return false
        }

        // Due date is required
        if (binding?.etDueDate?.text.toString().isEmpty()) {
            showMessage("Please select due date")
            return false
        }

        // Check if due date is before expiry date when both are set
        if (dueDateCalendar != null && expiryDateCalendar != null && dueDateCalendar!!.after(expiryDateCalendar)) {
            showMessage("Due date cannot be later than expiry date")
            return false
        }

        return true
    }

    // Select due date method
    private fun selectDueDate() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                dueDateCalendar = Calendar.getInstance()
                dueDateCalendar?.set(year, month, dayOfMonth)
                val format = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                binding?.etDueDate?.setText(format.format(dueDateCalendar?.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    // Select expiry date method
    private fun selectExpiryDate() {
        val calendar = Calendar.getInstance()
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                expiryDateCalendar = Calendar.getInstance()
                expiryDateCalendar?.set(year, month, dayOfMonth)
                val format = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                binding?.etExpiryDate?.setText(format.format(expiryDateCalendar?.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()
    }

    private fun showMessage(message: String?) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}