package com.example.miras.magazine.storage

import android.util.Log
import com.example.miras.magazine.auth.LoginResponse
import com.example.miras.magazine.auth.LoginStatus
import com.example.miras.magazine.core.util.Logger
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Observable

class RemoteStorageImpl : RemoteStorage {

    companion object {
        val auth = FirebaseAuth.getInstance()!!
    }

    override fun logout(): Observable<Unit?> {
        return Observable.fromCallable {
            auth.signOut()
        }
    }

    override fun login(email: String, password: String, listener: RemoteStorage.OnLoginFinishListener) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful)
                listener.onLoginSuccess(LoginResponse(auth.currentUser!!.uid,
                    email, password, LoginStatus(true, "OK")))

            else
                listener.onLoginFailed(LoginResponse("", email, password,
                    LoginStatus(false, it.exception?.message!!)))
        }
    }
}


