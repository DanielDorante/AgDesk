package com.example.agdesk.ViewModels



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agdesk.DomainLayer.repository.NetworkRepository
import com.example.agdesk.models.UIModels.TaskModel
import com.example.agdesk.DomainLayer.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Date
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val networkRepository: NetworkRepository): ViewModel() {

    private val _date = MutableStateFlow<Date>(Date(0))
    //state held here ready for collectors
    val date: StateFlow<Date> = _date.asStateFlow()


    init {
        loadTime()
    }

    //Saves a task to the database and refreshes the state post creation
    fun manualUpdate() = viewModelScope.launch {
        withContext(Dispatchers.IO) { //Executing jobs on the InputOutput Thread, good for database interaction
            networkRepository.syncToServer()
            networkRepository.syncFromServer()
            loadTime()
        }
    }
    //updates state with a list of all the tasks
    fun loadTime() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            val date = networkRepository.getSyncTimeUI()
            _date.value = date // Update the StateFlow
        }

    }



}