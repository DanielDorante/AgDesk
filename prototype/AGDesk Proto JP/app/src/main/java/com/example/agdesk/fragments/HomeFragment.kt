package com.example.agdesk.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agdesk.R
import com.example.agdesk.ViewModels.TaskViewModel
import com.example.agdesk.adapters.TasksAdapter
import com.example.agdesk.adapters.WeatherAdapter
import com.example.agdesk.database.DatabaseHelper
import com.example.agdesk.databinding.FragmentHomeBinding
import com.example.agdesk.models.UIModels.TaskModel
import com.example.agdesk.models.WeatherInfo
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.getValue


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var weatherAdapter: WeatherAdapter
    var listOfTasks: ArrayList<TaskModel> = ArrayList()
    lateinit var databaseHelper: DatabaseHelper
    lateinit var taskAdapter: TasksAdapter
    private val taskViewModel: TaskViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        databaseHelper = DatabaseHelper(requireContext())

        setAdapter()
        binding.addTaskBtn.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_addTaskFragment)
        }
        binding.tvViewAll.setOnClickListener {
            val bottomNavView = requireActivity().findViewById<BottomNavigationView>(R.id.nav_view)
            bottomNavView.selectedItemId = R.id.navigation_tasks
        }


    }

    private fun setAdapter() {
        val weatherList = listOf(
            WeatherInfo("Now", "10°", R.drawable.ic_cloud_shine),
            WeatherInfo("10am", "8°", R.drawable.ic_cloud),
            WeatherInfo("11am", "5°", R.drawable.ic_cloud),
            WeatherInfo("12pm", "12°", R.drawable.ic_cloud_shine),
            WeatherInfo("1pm", "9°", R.drawable.ic_cloud_shine),
            WeatherInfo("2pm", "12°", R.drawable.ic_cloud)
        )
        weatherAdapter = WeatherAdapter(weatherList)
        binding.recyclerWeather.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerWeather.adapter = weatherAdapter


        lifecycleScope.launch {
            withContext(Dispatchers.Default) {
                taskViewModel.loadUserTasks()

                taskViewModel.tasks.collect {savedTasks ->
                    listOfTasks.clear()
                    listOfTasks.addAll(savedTasks.take(4))

                    lifecycleScope.launch {
                        withContext(Dispatchers.Main) {
                            binding.recyclerTasks.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                            taskAdapter = TasksAdapter(listOfTasks,true)
                            binding.recyclerTasks.adapter = taskAdapter
                        }
                    }


                }
            }

        }




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}