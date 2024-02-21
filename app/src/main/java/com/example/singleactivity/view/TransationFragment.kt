package com.example.singleactivity.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.singleactivity.databinding.TransactionsListBinding
import com.example.singleactivity.model.Transaction
import com.example.singleactivity.viewmodel.TransactionViewModel
import kotlinx.coroutines.launch

/**
 * A fragment representing a list of Items.
 */
class TransationFragment : Fragment() {

    private lateinit var binding: TransactionsListBinding
    private lateinit var viewModel: TransactionViewModel
    private lateinit var data: List<Transaction>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TransactionsListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[TransactionViewModel::class.java]
        lifecycleScope.launch {
            viewModel.getAllTransaction()
        }
        viewModel.transactions.observe(viewLifecycleOwner){
            binding.list.layoutManager = LinearLayoutManager(requireContext())
            binding.list.adapter = TransactionViewAdapter(it, viewModel)
        }
//        lifecycleScope.launch {
//            val db = DbConnection()
//            data =db.getClient().from("trans").select().decodeList<Transaction>()
//
//        }.invokeOnCompletion {
//            binding.list.layoutManager = LinearLayoutManager(requireContext())
//            binding.list.adapter = TransactionViewAdapter(data)
//        }





        return binding.root
    }

}