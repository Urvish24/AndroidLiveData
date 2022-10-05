package com.hexagon.testapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hexagon.testapplication.base.BaseFragment
import com.hexagon.testapplication.databinding.FragmentSignupBinding

class SignupFragment : BaseFragment<FragmentSignupBinding>(
    FragmentSignupBinding::inflate
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.txtSignup.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

    }
}