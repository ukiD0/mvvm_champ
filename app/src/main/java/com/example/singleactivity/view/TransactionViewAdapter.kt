package com.example.singleactivity.view

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import com.example.singleactivity.R
import com.example.singleactivity.databinding.TransactionItemBinding
import com.example.singleactivity.model.Transaction
import com.example.singleactivity.viewmodel.TransactionViewModel


/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class TransactionViewAdapter(
    private val values: List<Transaction>,
    private val viewModel: TransactionViewModel
) : RecyclerView.Adapter<TransactionViewAdapter.ViewHolder>() {
    private val imgArr = arrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3
    )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            TransactionItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        if(item.money > 0){
            holder.money.setTextColor(Color.GREEN)
        }else{
            holder.money.setTextColor(Color.RED)
        }
        holder.money.text = item.money.toString()
        holder.name.text = item.name_trans
        holder.date.text = item.date
        holder.image.setImageResource(imgArr.get((0..2).random()))
        holder.container.setOnClickListener {
            viewModel.setTrans(item)
            Navigation.findNavController(holder.container).navigate(R.id.action_transationFragment_to_trans)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: TransactionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val money: TextView = binding.moneyTransTextView
        val name: TextView = binding.nameTransTextView
        val date: TextView = binding.dateTransTextView
        val image: ImageView = binding.imgAvatar
        val container: CardView = binding.cardContainer

    }

}