package com.hexagon.testapplication.oldpackage


import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dressvibe.businesslogic.interactors.ObservableString
import com.dressvibe.businesslogic.interactors.SingleLiveEvent
import com.hexagon.testapplication.oldpackage.jsonRequest.LoginReq


class MainActivityViewModel(private val mApplication : MyApplication) : ViewModel() {
     var emailStr : ObservableString = ObservableString("")
     var pwdStr : ObservableString = ObservableString("")
     var showStr : ObservableString = ObservableString("")
    var observerProgressBar = ObservableBoolean(false)
    private val eventClickSignIn: SingleLiveEvent<Boolean> = SingleLiveEvent()
    fun getEventSignIn():  SingleLiveEvent<Boolean>{
        return eventClickSignIn
    }

    fun clickSignIn() {
        eventClickSignIn.value = true && true
    }

    fun dataResponse() =  liveData {
        setProgressBar(true)
        val retService = RetrofitInstance.getRetrofitInstance()
            .create(ProjectService::class.java)
        val loginRes = LoginReq()
        loginRes.email = emailStr.get()
        loginRes.password = pwdStr.getTrimmed()
        loginRes.platform_os = 1
        loginRes.user_type = listOf("7","8")
        loginRes.fcm_token = "sdfvdfvdfsv"

        val response = retService.login(loginRes)
        Log.d("DATAA",response.isSuccessful.toString())
        setProgressBar(false)
        emit(response)
    }

    fun setProgressBar(visible: Boolean?) {
        observerProgressBar.set(visible!!)
    }
}