package com.hexagon.testapplication.di2

import androidx.lifecycle.ViewModelProvider
import com.google.firebase.firestore.core.ActivityScope
import com.hexagon.testapplication.repository.Repository
import com.hexagon.testapplication.viewmodels.LoginViewModel
import com.hexagon.testapplication.viewmodels.LoginViewModelFactory
import com.hexagon.testapplication.viewmodels.LoginViewModelFactory_Factory
import dagger.Module
import dagger.Provides

/*
@Module
class ViewModelModel {

    @Provides
    fun loginVmFactory(repository: Repository) : LoginViewModelFactory{
        return LoginViewModelFactory(repository)
    }

    @Provides
    fun loginViewModel(loginViewModelFactory : LoginViewModelFactory): LoginViewModel{
        return ViewModelProvider(this,loginViewModelFactory).get(LoginViewModel::class.java)
    }
}*/
