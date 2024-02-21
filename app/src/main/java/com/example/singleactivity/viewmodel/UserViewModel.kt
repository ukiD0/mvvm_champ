package com.example.singleactivity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.singleactivity.model.DbConnection
import com.example.singleactivity.model.Transaction
import io.github.jan.supabase.gotrue.SessionStatus
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.gotrue.user.UserInfo
import io.github.jan.supabase.postgrest.from

class UserViewModel :ViewModel() {
    private var _user: MutableLiveData<UserInfo> = MutableLiveData()
    val user: LiveData<UserInfo> = _user

    val db = DbConnection()

    suspend fun authUser(_email:String, _password:String){
        db.getClient().auth.signInWith(Email){
            email = _email
            password = _password
        }
        db.getClient().auth.sessionStatus.collect{
            when(it){
                is SessionStatus.Authenticated -> {
                    _user.value = it.session.user
                }
                SessionStatus.LoadingFromStorage -> {

                }
                SessionStatus.NetworkError -> {
                }
                SessionStatus.NotAuthenticated -> {

                }
            }
        }
    }
}