package com.example.singleactivity.view.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        return binding.root
    }

}