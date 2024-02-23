package com.example.singleactivity.view.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.singleactivity.R
import com.example.singleactivity.databinding.FragmentCreateAccountBinding

class CreateAccountFragment : Fragment() {
    private lateinit var binding: FragmentCreateAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateAccountBinding.inflate(inflater,container,false)

        binding.checkbox.setOnClickListener {
            binding.signup.isEnabled = (binding.fullname.text!!.length > 5
                    && binding.pphonenumber.text!!.length > 5
                    && binding.emailaddress.text!!.length > 5
                    && binding.emailaddress.text!!.contains("@")
                    && binding.emailaddress.text!!.contains(".")
                    && binding.password.text!!.trim().equals(binding.confirmPassword.text!!.trim())
                    && binding.password.text!!.length > 4
                    && binding.checkbox.isChecked)
        }

        binding.signup.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_createAccountFragment_to_homeFragment)
        }
        binding.appCompatTextView4.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.action_createAccountFragment_to_loginFragment)
        }



        return binding.root
    }

}