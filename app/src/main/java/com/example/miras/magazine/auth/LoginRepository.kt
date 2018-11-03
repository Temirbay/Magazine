package com.example.miras.magazine.auth

import android.annotation.SuppressLint
import com.example.miras.magazine.core.util.Logger
import com.example.miras.magazine.entities.User
import com.example.miras.magazine.storage.LocalStorage
import com.example.miras.magazine.storage.RemoteStorage
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.operators.observable.ObservableFromFuture
import io.reactivex.schedulers.Schedulers
import org.koin.standalone.KoinComponent

class LoginRepository(private val localStorage: LocalStorage,
                      private val remoteStorage: RemoteStorage)
    : AuthContract.LoginRepository, KoinComponent {

    @SuppressLint("CheckResult")
    override fun logout(): Observable<Unit?> {
        localStorage.deleteUser()
        return remoteStorage.logout()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun saveUserAndEmail(user: User, email: String) {
        localStorage.saveUserAndEmail(user, email)
    }


    override fun login(email: String, pass: String, listener:RemoteStorage.OnLoginFinishListener) {
        remoteStorage.login(email, pass, listener)
    }

    override fun lastEmail(): Observable<String?> {
        return localStorage.getUserEmail()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun isSigned() = localStorage.getUser()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())!!
}