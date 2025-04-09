package com.example.agdesk.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agdesk.R
import com.example.agdesk.adapters.DateAdapter
import com.example.agdesk.adapters.TasksAdapter
import com.example.agdesk.database.DatabaseHelper
import com.example.agdesk.databinding.FragmentTasksBinding
import com.example.agdesk.models.HelperClass
import com.example.agdesk.models.TaskModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class TasksFragment : Fragment() {

    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!
    var adapter: DateAdapter? = null
    var date: String? = null
    var timeInMillis: Long = System.currentTimeMillis()
    var listOfTasks: ArrayList<TaskModel> = ArrayList()
    lateinit var databaseHelper: DatabaseHelper
    lateinit var taskAdapter: TasksAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databaseHelper = DatabaseHelper(requireContext())
        setDatePicker()
        setAdapter()
        setSortSpinner()
        binding.btnAddTask.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_tasks_to_addTaskFragment)
        }

    }

    private fun setAdapter() {
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvTasks.layoutManager = layoutManager
        taskAdapter = TasksAdapter(listOfTasks, false)
        binding.rvTasks.adapter = taskAdapter
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
                        listOfTasks.clear()
                        listOfTasks.addAll(databaseHelper.getAllTasks(HelperClass.users?.id.toString()))
                        taskAdapter.setList(listOfTasks)
                    }

                    "Weekly" -> {
                        listOfTasks.clear()
                        listOfTasks.addAll(databaseHelper.getWeeklyTasks(HelperClass.users?.id.toString()))
                        taskAdapter.setList(listOfTasks)
                    }

                    "Monthly" -> {
                        listOfTasks.clear()
                        listOfTasks.addAll(databaseHelper.getMonthlyTasks(HelperClass.users?.id.toString()))
                        taskAdapter.setList(listOfTasks)
                    }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // write code to perform some action
            }
        }
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