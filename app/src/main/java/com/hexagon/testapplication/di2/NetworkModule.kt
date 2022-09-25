package com.hexagon.testapplication.di2

import com.google.gson.GsonBuilder
import com.hexagon.testapplication.oldpackage.ProjectService
import com.hexagon.testapplication.oldpackage.RetrofitInstance
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{
        //val BASE_URL = "https://node.inheritxdev.in/QDIS-Dev/v1/"
        val BASE_URL = "https://api.instantwebtools.net/"
        val interceptor = HttpLoggingInterceptor().apply {
            this.level =  HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(25, TimeUnit.SECONDS)
        }.build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    @Singleton
    @Provides
    fun providesProjectServiceApi(retrofit: Retrofit) : ProjectService{
        return  retrofit.create(ProjectService::class.java)
    }
}