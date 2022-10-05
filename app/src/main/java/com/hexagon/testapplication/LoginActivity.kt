package com.hexagon.testapplication

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dressvibe.businesslogic.sharedpreference.UtilsSharedPreferences
import com.hexagon.testapplication.base.BaseActivity
import com.hexagon.testapplication.databinding.ActivityLoginBinding
import com.hexagon.testapplication.databinding.FragmentSignupBinding
import com.hexagon.testapplication.repository.Response
import com.hexagon.testapplication.viewmodels.LoginViewModel
import com.hexagon.testapplication.viewmodels.LoginViewModelFactory
import java.util.*
import javax.inject.Inject


class LoginActivity : BaseActivity<ActivityLoginBinding>(
    ActivityLoginBinding::inflate
) {

    lateinit var loginViewModel: LoginViewModel

   // lateinit var binding: ActivityLoginBinding

    var places: List<String> = Arrays.asList("One", "Two", "Three")
    var nee = arrayOf("sdd")


    @Inject
    lateinit var loginViewModelFactory: LoginViewModelFactory

    @Inject
    lateinit var utilsSharedPreferences: UtilsSharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        (application as MyApplication).applicationComponent.inject(this)
        loginViewModel = ViewModelProvider(this,loginViewModelFactory).get(LoginViewModel::class.java)
        binding.myViewModel = loginViewModel

        val adapter: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, places)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter

        Log.d("Preff",utilsSharedPreferences.getBoolean("Login",false).toString())
        observeViewModels();
    }

    private fun observeViewModels(){
        with(loginViewModel){
            LoginLiveData.observe(this@LoginActivity, Observer {
                // utilsSharedPreferences.setBoolean("Login",true)
                when(it){
                    is Response.Loading ->{}
                    is Response.Success ->{
                        utilsSharedPreferences.setBoolean("Login",true)
                    }
                    is Response.Error ->{}
                }
            })

            loginViewModel.spinnerLiveData.observe(this@LoginActivity, Observer {
                Toast.makeText(this@LoginActivity,it.toString(),Toast.LENGTH_LONG).show()
            })
        }
    }
} 