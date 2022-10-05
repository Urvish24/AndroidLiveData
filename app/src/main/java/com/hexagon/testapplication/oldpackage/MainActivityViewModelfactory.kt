package com.hexagon.testapplication.oldpackage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hexagon.testapplication.MyApplication

class MainActivityViewModelFactory (
    private val myApplication: MyApplication
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(myApplication) as T
    }
}