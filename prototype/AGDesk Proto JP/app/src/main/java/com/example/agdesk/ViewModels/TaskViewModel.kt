package com.example.agdesk.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agdesk.models.AssetModel
import com.example.agdesk.models.TaskModel
import com.example.agdesk.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class TaskViewModel @Inject constructor(private val taskRepository: TaskRepository): ViewModel() {

    private val _tasks = MutableStateFlow<List<TaskModel>>(emptyList())
    //state held here ready for collectors
    val tasks: StateFlow<List<TaskModel>> = _tasks.asStateFlow()


    init {
        loadTasks()
    }

    fun insertTasks(vararg taskModel: TaskModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) { //Executing jobs on the InputOutput Thread, good for database interaction
            taskRepository.insertTask(*taskModel)
            loadTasks()
        }
    }

    fun loadTasks() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val taskList = taskRepository.getAllTasks()
            _tasks.value = taskList // Update the StateFlow
        }

    }

    fun loadUserTasks() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val taskList = taskRepository.getThisUsersTasks()
            _tasks.value = taskList // Update the StateFlow
        }

    }

    fun updateTask(taskModel: TaskModel) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            taskRepository.updateTask(taskModel)
            loadTasks()
        }
    }

}