package com.example.singleactivity.view.registration

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
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
//        binding.one.doAfterTextChanged {
//            binding.one.resources.getDrawable(R.drawable.inputtext_bl)
//        }
        binding.six.doAfterTextChanged {
            if(binding.one.text!!.length == 1
                && binding.two.text!!.length ==1
                && binding.three.text!!.length ==1
                && binding.four.text!!.length ==1
                && binding.five.text!!.length ==1
                && binding.six.text!!.length ==1){
                binding.signup.isEnabled = true
            }else{
                binding.signup.isEnabled = false
            }
        }

        return binding.root
    }
}