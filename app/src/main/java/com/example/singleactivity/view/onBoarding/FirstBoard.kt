package com.example.singleactivity.view.onBoarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.singleactivity.R
import com.example.singleactivity.databinding.FragmentFirstBoardBinding
import com.example.singleactivity.databinding.FragmentThirdBoardBinding

class FirstBoard : Fragment() {
    private lateinit var binding: FragmentFirstBoardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBoardBinding.inflate(inflater,container,false)

        val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewpager)

        binding.btSkip.setOnClickListener {
            viewPager?.currentItem = 2
        }

        binding.btNext.setOnClickListener {
            viewPager?.currentItem = 1
        }


        return binding.root
    }
}