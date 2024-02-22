package com.example.singleactivity.view.onBoarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.example.singleactivity.R
import com.example.singleactivity.databinding.FragmentThirdBoardBinding

class ThirdBoard : Fragment() {
        private lateinit var binding: FragmentThirdBoardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentThirdBoardBinding.inflate(inflater,container,false)

//        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewpager)

        binding.btNext.setOnClickListener {
            onBoardingFinished()
            Navigation.findNavController(binding.root).navigate(R.id.action_viewPagerFragment_to_createAccountFragment)
        }

        return binding.root
    }

    private fun onBoardingFinished(){
        val sharedPreferences = requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("Finished",true)
        editor.apply()
    }

}