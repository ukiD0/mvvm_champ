package com.example.singleactivity.view.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.singleactivity.R
import com.example.singleactivity.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {
    private lateinit var binding: FragmentForgotPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotPasswordBinding.inflate(inflater,container,false)

        binding.signup.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_forgotPasswordFragment_to_OTPVerificationFragment)
        }

        binding.appCompatTextView4.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_forgotPasswordFragment_to_loginFragment)
        }

        return binding.root
    }

}