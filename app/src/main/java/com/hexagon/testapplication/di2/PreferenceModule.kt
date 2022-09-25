package com.hexagon.testapplication.di2

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.GsonBuilder
import com.hexagon.testapplication.oldpackage.RetrofitInstance
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class PreferenceModule {

    @Singleton
    @Provides
    fun providePreference(context : Context) : SharedPreferences{
        return context.getSharedPreferences("UvShared", Context.MODE_PRIVATE)
    }

}