package com.hexagon.testapplication.viewmodels

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dressvibe.businesslogic.interactors.ObservableString
import com.hexagon.testapplication.oldpackage.jsonRequest.LoginReq
import com.hexagon.testapplication.oldpackage.pojo.LoginResponse
import com.hexagon.testapplication.repository.Repository
import com.hexagon.testapplication.repository.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginViewModel (private val repository : Repository) : ViewModel() {

    val LoginLiveData : LiveData<Response<LoginResponse>>
    get() = repository.loginResponse

    val spinnerSelectedPositioacdscn = MutableLiveData<ArrayList<Int>>()

    val spinnerSelectedPosition = MutableLiveData<Int>()
    val spinnerLiveData : LiveData<Int>
        get() = spinnerSelectedPosition
    //var spinnerData : MutableLiveData<country>

    var emailStr : ObservableString = ObservableString("")
    var pwdStr : ObservableString = ObservableString("")
    var showStr : ObservableString = ObservableString("")
    var observerProgressBar = ObservableBoolean(false)

    fun clickSignIn() {
        setProgressBar(true)
        spinnerSelectedPositioacdscn.value?.add(4)
         viewModelScope.launch(Dispatchers.IO) {
             val loginRes = LoginReq()
             loginRes.email = emailStr.get()
             loginRes.password = pwdStr.getTrimmed()
             loginRes.platform_os = 1
             loginRes.user_type = listOf("7","8")
             loginRes.fcm_token = "123456"
             repository.getlogin(loginRes)
             withContext(Dispatchers.Main){
                 setProgressBar(false)
             }
         }
    }

    fun setProgressBar(visible: Boolean?) {
        observerProgressBar.set(visible!!)
    }


}