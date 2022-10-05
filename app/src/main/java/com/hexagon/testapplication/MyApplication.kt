package com.hexagon.testapplication

import android.app.Application
import com.hexagon.testapplication.di2.ApplicationComponent
import com.hexagon.testapplication.di2.DaggerApplicationComponent

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        //When you don't have any run time object like context
        //applicationComponent =  DaggerApplicationComponent.builder().build()


        //if you  have any run time object like context
        applicationComponent =  DaggerApplicationComponent.factory().create(this)
    }
}