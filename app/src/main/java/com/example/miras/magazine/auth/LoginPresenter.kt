package com.example.miras.magazine.auth

import android.annotation.SuppressLint
import com.example.miras.magazine.core.util.BasePresenter
import com.example.miras.magazine.core.util.Logger
import com.example.miras.magazine.entities.User
import com.example.miras.magazine.storage.RemoteStorage
import io.reactivex.Observable


class LoginPresenter(private val repository: AuthContract.LoginRepository)
    : BasePresenter<AuthContract.LoginView>(), AuthContract.LoginPresenter,
        RemoteStorage.OnLoginFinishListener{


    override fun viewIsReady() {

    }

    override fun destroy() {

    }

    override fun onLoginSuccess(response: LoginResponse) {
        val user = User(response.user_id, response.email, response.password)
        repository.saveUserAndEmail(user, response.email)
        getView()?.onLoginSuccess()
    }

    override fun onLoginFailed(response: LoginResponse) {
        getView()?.onLoginError(response.status.message)
    }


    @SuppressLint("CheckResult")
    override fun attachView(view: AuthContract.LoginView) {
        super.attachView(view)
        repository.isSigned().subscribe(
            {
                if (it != null){
                    Logger.test("isSigned", it.toString())
                    getView()?.onLoginSuccess()
                }
            },{
            Logger.test("LoginPresenter", "userFail "+ it.message)
        })
    }

    @SuppressLint("CheckResult")
    override fun loginUser(email: String, pass: String) {
        repository.login(email, pass, this)
    }

    @SuppressLint("CheckResult")
    override fun lastUserEmail() {
        repository.lastEmail().subscribe {
            getView()?.setEmail(it)
        }
    }

}