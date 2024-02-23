package com.example.singleactivity.view.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.Navigation
import com.example.singleactivity.R
import com.example.singleactivity.databinding.FragmentNewPasswordBinding


class NewPasswordFragment : Fragment() {
    private lateinit var binding: FragmentNewPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewPasswordBinding.inflate(inflater,container,false)

        binding.signup.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_newPasswordFragment_to_homeFragment)
        }
        binding.conpass.doAfterTextChanged{
            if(binding.password.text!!.trim().equals(binding.conpass.text!!.trim())
                && binding.password.text!!.length > 5){
                binding.signup.isEnabled = false
                }else{
                    binding.signup.isEnabled = true
            }
        }

        return binding.root
    }

}