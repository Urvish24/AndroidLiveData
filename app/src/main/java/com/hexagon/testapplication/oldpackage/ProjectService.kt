package com.hexagon.testapplication.oldpackage

import com.hexagon.testapplication.oldpackage.jsonRequest.LoginReq
import com.hexagon.testapplication.oldpackage.pojo.Airlines
import com.hexagon.testapplication.oldpackage.pojo.LoginResponse
import retrofit2.Response
import retrofit2.http.*

interface ProjectService {

    @Headers("Content-Type: application/json", "Cache-Control: no-cache")
    @POST("users/login")
    suspend fun login(@Body body: LoginReq) : Response<LoginResponse>

    @GET("v1/passenger")
    suspend fun getAirlines(@Query("page") page : Int,@Query("size") size : Int) : Response<Airlines>

}