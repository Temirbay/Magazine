package com.example.miras.magazine.profile

import android.annotation.SuppressLint
import com.example.miras.magazine.auth.AuthContract
import com.example.miras.magazine.core.util.BasePresenter

class ProfilePresenter(private val repository: AuthContract.LoginRepository)
    :BasePresenter<ProfileContract.ProfileView>(), ProfileContract.ProfilePresenter {

    @SuppressLint("CheckResult")
    override fun logout() {
        repository.logout().subscribe {
            getView()?.onLogoutSuccess()
        }
    }

    override fun viewIsReady() {

    }

    override fun destroy() {

    }
}