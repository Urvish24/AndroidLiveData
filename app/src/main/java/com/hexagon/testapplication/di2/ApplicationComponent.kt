package com.hexagon.testapplication.di2

import android.content.Context
import com.hexagon.testapplication.AirlineActivity
import com.hexagon.testapplication.LoginActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class,PreferenceModule::class])
interface ApplicationComponent {

    fun inject(loginActivity: LoginActivity)
    fun inject(airlineActivity: AirlineActivity)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context : Context) : ApplicationComponent
    }
}