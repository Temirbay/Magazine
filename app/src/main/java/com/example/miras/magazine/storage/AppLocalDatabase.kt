package com.example.miras.magazine.storage

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.miras.magazine.entities.Email
import com.example.miras.magazine.entities.User
import kz.darlogistics.courier2.room.EmailDao
import kz.darlogistics.courier2.room.UserDao


@Database(entities = [User::class, Email::class], version = 1)
abstract class AppLocalDatabase: RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun emailDao() : EmailDao
}