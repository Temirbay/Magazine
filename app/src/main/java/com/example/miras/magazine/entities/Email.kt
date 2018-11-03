package com.example.miras.magazine.entities

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "emails")
data class Email(
    @PrimaryKey val email: String
)