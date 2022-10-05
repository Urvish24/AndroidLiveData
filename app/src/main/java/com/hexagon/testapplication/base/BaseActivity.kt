package com.hexagon.testapplication.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseActivity </*VM : ViewModel,*/B : ViewBinding>(
    val bindingFactory: (LayoutInflater) -> B) : AppCompatActivity(){

    //private var _viewModel: VM? = null
    private var _binding: B? = null

    val binding: B
        get() = _binding as B

    /*val viewModel: VM
        get() = _viewModel as VM*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // _viewModel = ViewModelProvider(this).get(getViewModelClass())
        _binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
    }

   /* private fun getViewModelClass(): Class<VM> {
        val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return type as Class<VM>
    }*/
}