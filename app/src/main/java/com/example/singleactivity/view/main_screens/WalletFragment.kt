package com.example.singleactivity.view.main_screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.singleactivity.R
import com.example.singleactivity.databinding.FragmentWalletBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class WalletFragment : Fragment() {
    private lateinit var binding: FragmentWalletBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWalletBinding.inflate(inflater,container,false)

        val btmenu = requireActivity().findViewById<BottomNavigationView>(R.id.bottomMenuMy)
        btmenu.isVisible = true

        return binding.root
    }

}