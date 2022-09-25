package com.hexagon.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.hexagon.testapplication.databinding.ActivityAirlineBinding
import com.hexagon.testapplication.repository.Response
import com.hexagon.testapplication.viewmodels.AirlineViewModel
import com.hexagon.testapplication.viewmodels.AirlineViewModelFactory
import com.hexagon.testapplication.viewmodels.LoginViewModelFactory
import javax.inject.Inject

class AirlineActivity : AppCompatActivity() {

    lateinit var airlineViewModel: AirlineViewModel

    lateinit var binding : ActivityAirlineBinding

    private lateinit var adapter: AirlinesAdapter

    @Inject
    lateinit var airlineViewModelFactory: AirlineViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_airline)
        (application as MyApplication).applicationComponent.inject(this)
        airlineViewModel = ViewModelProvider(this,airlineViewModelFactory).get(AirlineViewModel::class.java)
        binding.myViewModel = airlineViewModel
        initRecyclerView()

        airlineViewModel.AirlineLiveData.observe(this, Observer {
            when(it){
                is Response.Loading ->{}
                is Response.Success ->{
                    Log.d("RESSSPONSSEE",it.toString())
                    val array = it.data?.data
                    array?.let { it1 -> adapter.setList(it1) }
                    adapter.notifyDataSetChanged()
                }
                is Response.Error ->{}
            }
        })



    }
    private fun initRecyclerView(){

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AirlinesAdapter()
        binding.recyclerView.adapter = adapter

    }
}