package com.example.singleactivity.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.singleactivity.R
import com.example.singleactivity.databinding.FragmentTransBinding
import com.example.singleactivity.viewmodel.TransactionViewModel
import com.example.singleactivity.viewmodel.UserViewModel
import kotlinx.coroutines.launch


class Trans : Fragment() {
    private lateinit var binding:FragmentTransBinding
//    private lateinit var viewModel: TransactionViewModel
    private lateinit var viewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTransBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[UserViewModel::class.java]
        lifecycleScope.launch {
            viewModel.authUser("test@testevgen.ru", "123456789")
        }
        viewModel.user.observe(viewLifecycleOwner){
            binding.nameTransaction.text = it.email
            binding.dateTrans.text = it.phone
            binding.moneyTrans.text = it.createdAt.toString()
        }
//        viewModel = ViewModelProvider(requireActivity())[TransactionViewModel::class.java]
//        viewModel.trans.observe(viewLifecycleOwner){
//            binding.nameTransaction.text = it.name_trans
//            binding.descriptionTrans.text = it.description
//            binding.moneyTrans.text = it.money.toString()
//            binding.dateTrans.text = it.date
//        }

        return binding.root
    }


}