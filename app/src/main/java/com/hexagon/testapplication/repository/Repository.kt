package com.hexagon.testapplication.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hexagon.testapplication.oldpackage.ProjectService
import com.hexagon.testapplication.oldpackage.jsonRequest.LoginReq
import com.hexagon.testapplication.oldpackage.pojo.Airlines
import com.hexagon.testapplication.oldpackage.pojo.LoginResponse
import javax.inject.Inject

class Repository @Inject constructor(private val projectService: ProjectService) {

    private val _loginResponseMutableLiveData = MutableLiveData<Response<LoginResponse>>()
    val loginResponse: LiveData<Response<LoginResponse>>
        get() = _loginResponseMutableLiveData

    private val _airlinesResponseMutableLiveData = MutableLiveData<Response<Airlines>>()
    val airlinesResponse : LiveData<Response<Airlines>>
        get() = _airlinesResponseMutableLiveData

    suspend fun getlogin(loginReq: LoginReq) {
        try {
            val result = projectService.login(loginReq)
            if (result.isSuccessful && result.body() != null) {
                _loginResponseMutableLiveData.postValue(Response.Success(result.body()))
            } else {
                _loginResponseMutableLiveData.postValue(Response.Error(result.message()))
            }
        } catch (e: Exception) {
            _loginResponseMutableLiveData.postValue(Response.Error(e.message.toString()))
        }
    }

    suspend fun getAirlines(page:Int,size : Int) {
        try {
            val result = projectService.getAirlines(page,size)
            if (result.isSuccessful && result.body() != null) {
                _airlinesResponseMutableLiveData.postValue(Response.Success(result.body()))
            } else {
                _airlinesResponseMutableLiveData.postValue(Response.Error(result.message()))
            }
        } catch (e: Exception) {
            _airlinesResponseMutableLiveData.postValue(Response.Error(e.message.toString()))
        }
    }


}