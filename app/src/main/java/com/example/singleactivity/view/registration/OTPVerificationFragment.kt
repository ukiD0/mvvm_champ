package com.example.singleactivity.view.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.singleactivity.R
import com.example.singleactivity.databinding.FragmentOTPVerificationBinding

class OTPVerificationFragment : Fragment() {
    private lateinit var binding: FragmentOTPVerificationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOTPVerificationBinding.inflate(inflater,container,false)

        binding.signup.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_OTPVerificationFragment_to_newPasswordFragment)
        }

        return binding.root
    }
}