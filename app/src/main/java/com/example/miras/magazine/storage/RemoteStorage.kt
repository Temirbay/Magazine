package com.example.miras.magazine.storage

import com.example.miras.magazine.auth.LoginResponse
import com.example.miras.magazine.auth.LoginStatus
import io.reactivex.Observable

interface RemoteStorage {

    fun login (email : String, password : String, listener : OnLoginFinishListener)
    fun logout () : Observable<Unit?>

    interface OnLoginFinishListener  {
        fun onLoginSuccess (response: LoginResponse)
        fun onLoginFailed (response: LoginResponse)
    }
}