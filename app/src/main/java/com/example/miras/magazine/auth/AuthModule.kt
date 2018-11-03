package com.example.miras.magazine.auth

import org.koin.dsl.module.module

val authModule = module {

    factory { LoginPresenter(get()) as AuthContract.LoginPresenter }
    factory { LoginRepository(get(), get()) as AuthContract.LoginRepository }

}