package com.example.singleactivity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.singleactivity.model.DbConnection
import com.example.singleactivity.model.Transaction
import io.github.jan.supabase.postgrest.from

class TransactionViewModel :ViewModel() {
    private var _transactions:MutableLiveData<List<Transaction>> = MutableLiveData()
    val transactions:LiveData<List<Transaction>> = _transactions

    private var _trans: MutableLiveData<Transaction> = MutableLiveData()
    val trans: LiveData<Transaction> = _trans

    val db = DbConnection()

    fun setTrans(trans: Transaction){
        _trans.value = trans
    }

    suspend fun getAllTransaction(){
        _transactions.value = db.getClient().from("trans").select().decodeList()
    }
}