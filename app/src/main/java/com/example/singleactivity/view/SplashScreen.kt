package com.example.singleactivity.view

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.singleactivity.R
import com.example.singleactivity.databinding.FragmentSplashScreenBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers

class SplashScreen : Fragment() {

private lateinit var _binding: FragmentSplashScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)

        val menu = requireActivity().findViewById<BottomNavigationView>(R.id.bottomMenuMy)
        menu.visibility = View.GONE

        Handler(Looper.getMainLooper()).postDelayed({
            if(onBoardingFinished()){
                findNavController().navigate(R.id.action_splashScreen_to_createAccountFragment)
            }else
                findNavController().navigate(R.id.action_splashScreen_to_viewPagerFragment)
        },2000)
        return _binding.root
    }

    private fun onBoardingFinished(): Boolean {
        val sharedPreferences = requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("Finished", false)
    }

}