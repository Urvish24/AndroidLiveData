package com.hexagon.testapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hexagon.testapplication.oldpackage.pojo.Airlines
import com.hexagon.testapplication.oldpackage.pojo.LoginResponse
import com.hexagon.testapplication.repository.Repository
import com.hexagon.testapplication.repository.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AirlineViewModel (private val repository : Repository) : ViewModel(){
    val AirlineLiveData : LiveData<Response<Airlines>>
        get() = repository.airlinesResponse

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAirlines(0,10)
        }
    }
}