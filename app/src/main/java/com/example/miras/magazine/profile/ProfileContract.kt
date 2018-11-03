package com.example.miras.magazine.profile

import com.example.miras.magazine.core.util.IPresenter
import com.example.miras.magazine.core.util.IView

interface ProfileContract {

    interface ProfileView : IView<ProfilePresenter> {
        fun onLogoutSuccess ()
    }

    interface ProfilePresenter : IPresenter<ProfileView> {
        fun logout ()
    }


}