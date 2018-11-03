package com.example.miras.magazine.auth

import com.example.miras.magazine.core.util.IPresenter
import com.example.miras.magazine.core.util.IView
import com.example.miras.magazine.entities.User
import com.example.miras.magazine.storage.RemoteStorage
import io.reactivex.Observable

interface AuthContract {

    interface LoginView : IView<LoginPresenter> {
        fun onLoginSuccess()
        fun onLoginError(message: String)
        fun setEmail(email: String?)
    }

    interface LoginPresenter : IPresenter<LoginView> {
        fun loginUser(email: String, pass: String)
        fun lastUserEmail()
    }

    interface LoginRepository {
        fun login(email: String, pass: String, listener: RemoteStorage.OnLoginFinishListener)
        fun isSigned(): Observable<User?>
        fun lastEmail(): Observable<String?>
        fun saveUserAndEmail(user: User, email: String)
        fun logout () : Observable<Unit?>
    }

}