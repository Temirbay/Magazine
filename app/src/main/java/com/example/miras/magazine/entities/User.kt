package com.example.miras.magazine.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class User (
    @PrimaryKey
    val id : String,
    val email : String,
    val password : String
)