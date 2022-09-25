package com.hexagon.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dressvibe.businesslogic.sharedpreference.UtilsSharedPreferences
import com.hexagon.testapplication.databinding.ActivityLoginBinding
import com.hexagon.testapplication.repository.Response
import com.hexagon.testapplication.viewmodels.LoginViewModel
import com.hexagon.testapplication.viewmodels.LoginViewModelFactory
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    lateinit var loginViewModel: LoginViewModel

    lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var loginViewModelFactory: LoginViewModelFactory

    @Inject
    lateinit var utilsSharedPreferences: UtilsSharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        (application as MyApplication).applicationComponent.inject(this)
        loginViewModel = ViewModelProvider(this,loginViewModelFactory).get(LoginViewModel::class.java)
        binding.myViewModel = loginViewModel
        Log.d("Preff",utilsSharedPreferences.getBoolean("Login",false).toString())
       loginViewModel.LoginLiveData.observe(this, Observer {
           // utilsSharedPreferences.setBoolean("Login",true)
          when(it){
              is Response.Loading ->{}
              is Response.Success ->{
                  utilsSharedPreferences.setBoolean("Login",true)
              }
              is Response.Error ->{}
          }
       })

    }
} 