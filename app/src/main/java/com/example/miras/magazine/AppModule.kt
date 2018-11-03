package com.example.miras.magazine

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.migration.Migration
import android.content.Context
import com.example.miras.magazine.auth.authModule
import com.example.miras.magazine.core.coreModule
import com.example.miras.magazine.profile.ProfileContract
import com.example.miras.magazine.profile.ProfilePresenter
import com.example.miras.magazine.storage.*
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module


val appModule = module {
    factory { createLocalStorage(androidContext())}

    factory { LocalStorageImpl(get()) as LocalStorage }

    factory { RemoteStorageImpl() as RemoteStorage }


    factory { ProfilePresenter(get()) as ProfileContract.ProfilePresenter}
}

fun createLocalStorage(context: Context): AppLocalDatabase {
    return Room.databaseBuilder(context, AppLocalDatabase::class.java,"MagazineDb")
        .build()
}


val appModules = listOf(
    authModule,
    coreModule,
    appModule
)