package com.example.agdesk.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agdesk.R
import com.example.agdesk.adapters.DateAdapter
import com.example.agdesk.adapters.TasksAdapter
import com.example.agdesk.ViewModels.AssetViewModel
import com.example.agdesk.ViewModels.TaskViewModel
import com.example.agdesk.databinding.FragmentTasksBinding
import com.example.agdesk.models.UIModels.TaskModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class TasksFragment : Fragment(), TasksAdapter.TaskItemListener {
    private val assetViewModel: AssetViewModel by viewModels()
    private val taskViewModel: TaskViewModel by viewModels()

    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!

    private var adapter: DateAdapter? = null
    private lateinit var taskAdapter: TasksAdapter

    var date: String? = null
    var timeInMillis: Long = System.currentTimeMillis()
    private val tasksList = mutableListOf<TaskModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setDatePicker()
        setSortSpinner()

        // Observe tasks using collectLatest to ensure we always have the latest data
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                taskViewModel.tasks.collectLatest { tasks ->
                    updateTasksList(tasks)
                }
            }
        }

        binding.btnAddTask.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_tasks_to_addTaskFragment)
        }
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvTasks.layoutManager = layoutManager

        // Initialize the adapter with empty list and this fragment as the listener
        taskAdapter = TasksAdapter(emptyList(), false, this)
        binding.rvTasks.adapter = taskAdapter
    }

    // TaskItemListener implementation
    override fun onEditClick(task: TaskModel) {
        // Create a bundle to pass the task to AddTaskFragment
        val bundle = Bundle().apply {
            putSerializable(AddTaskFragment.ARG_TASK, task)
        }

        // Navigate to AddTaskFragment with the task data using Navigation component
        findNavController().navigate(R.id.action_navigation_tasks_to_addTaskFragment, bundle)
    }

    override fun onDeleteClick(task: TaskModel) {
        // Show confirmation dialog before deleting
        AlertDialog.Builder(requireContext())
            .setTitle("Delete Task")
            .setMessage("Are you sure you want to delete this task?")
            .setPositiveButton("Delete") { _, _ ->
                taskViewModel.deleteTask(task)
                Toast.makeText(requireContext(), "Task deleted successfully", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun updateTasksList(tasks: List<TaskModel>) {
        tasksList.clear()
        tasksList.addAll(tasks)

        // Update UI on the main thread
        binding.emptyStateLayout.visibility = if (tasks.isEmpty()) View.VISIBLE else View.GONE
        binding.rvTasks.visibility = if (tasks.isEmpty()) View.GONE else View.VISIBLE

        // Apply the updates to the adapter
        taskAdapter.setList(tasks)

        // If a date is selected, filter tasks for that date
        if (date != null) {
            filterTasksByDate(timeInMillis)
        }
    }

    private fun setSortSpinner() {
        val sortList = arrayOf("All", "Weekly", "Monthly")

        val adapter = ArrayAdapter(
            requireActivity(),
            R.layout.item_sort, sortList
        )
        binding.spSort.adapter = adapter

        binding.spSort.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?, position: Int, id: Long
            ) {
                when (sortList[position]) {
                    "All" -> {
                        taskViewModel.loadTasks()
                    }
                    "Weekly" -> {
                        taskViewModel.loadTasksByTimeFrame("Week")
                    }
                    "Monthly" -> {
                        taskViewModel.loadTasksByTimeFrame("Month")
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No action needed
            }
        }
    }

    // Get days of the current month
    private fun getDaysOfMonth(year: Int, month: Int): List<Long> {
        val calendar = Calendar.getInstance()
        calendar[year, month - 1] = 1

        val daysOfMonth: MutableList<Long> = ArrayList()

        while (calendar[Calendar.MONTH] == month - 1) {
            daysOfMonth.add(calendar.timeInMillis)
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        return daysOfMonth
    }

    private fun setDatePicker() {
        // Get the current date
        val currentCalendar = Calendar.getInstance()
        currentCalendar.timeInMillis = System.currentTimeMillis()

        // Get days of the current month
        val days: List<Long> = getDaysOfMonth(getCurrentYear(), getCurrentMonth())

        adapter = DateAdapter(days, object : DateAdapter.OnSelected {
            override fun onSelected(data: Long) {
                timeInMillis = data
                date = getCurrentDate(data)

                // Filter tasks by the selected date
                filterTasksByDate(data)
            }
        })

        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvDates.layoutManager = layoutManager
        binding.rvDates.adapter = adapter

        // Find the current date in the list and set it as selected
        for (dateInMillis in days) {
            val calendar = Calendar.getInstance()
            calendar.timeInMillis = dateInMillis

            // Compare just the year, month, and day (ignoring time)
            if (currentCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) &&
                currentCalendar.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                currentCalendar.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)
            ) {
                adapter!!.setSelectedPosition(days.indexOf(dateInMillis))
                binding.rvDates.scrollToPosition(adapter!!.getSelectedPosition())
                break
            }
        }

        binding.rvDates.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val centerPosition = layoutManager.findFirstCompletelyVisibleItemPosition()
                    layoutManager.scrollToPositionWithOffset(centerPosition, 0)
                }
            }
        })
    }

    private fun filterTasksByDate(selectedDateInMillis: Long) {
        // We need to implement this method in the ViewModel or adapt our current tasks list
        // For now, we'll reload all tasks - ideally this would filter by date
        taskViewModel.loadTasks()
    }

    // Get the current year
    private fun getCurrentYear(): Int {
        val calendar = Calendar.getInstance()
        return calendar[Calendar.YEAR]
    }

    // Get the current month
    private fun getCurrentMonth(): Int {
        val calendar = Calendar.getInstance()
        // Calendar months are 0-based, so add 1 to get the actual month
        return calendar[Calendar.MONTH] + 1
    }

    // Get the formatted current date
    private fun getCurrentDate(time: Long): String {
        val sdf = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
        return sdf.format(Date(time))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}