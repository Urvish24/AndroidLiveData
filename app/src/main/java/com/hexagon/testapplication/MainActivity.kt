package com.hexagon.testapplication

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hexagon.testapplication.databinding.ActivityMainBinding
import com.hexagon.testapplication.oldpackage.ActivityBase
import com.hexagon.testapplication.oldpackage.MainActivityViewModel
import com.hexagon.testapplication.oldpackage.MainActivityViewModelFactory

class MainActivity : ActivityBase() {
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var mainActivityViewModelFactory: MainActivityViewModelFactory
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.myViewModel = mainActivityViewModel
       // mainActivityViewModelFactory = MainActivityViewModelFactory(myApplication = mApplication)
        mainActivityViewModel.getEventSignIn().observe(this, Observer {
            if(it) {
                val responseLiveData =  mainActivityViewModel.dataResponse()
                responseLiveData.observe(this, Observer {
                    Log.i("MYTAG", it.toString())
                })
            }
        })


    }
}