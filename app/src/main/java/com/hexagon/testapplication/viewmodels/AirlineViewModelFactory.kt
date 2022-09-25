package com.hexagon.testapplication.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hexagon.testapplication.repository.Repository
import javax.inject.Inject

class AirlineViewModelFactory @Inject constructor(
    private val repository: Repository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AirlineViewModel(repository) as T
    }
}