package com.hexagon.testapplication

import android.app.Application
import com.hexagon.testapplication.di2.ApplicationComponent
import com.hexagon.testapplication.di2.DaggerApplicationComponent

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        //applicationComponent =  DaggerApplicationComponent.builder().build()

        applicationComponent =  DaggerApplicationComponent.factory().create(this)
    }
}