package com.example.miras.magazine.auth

data class LoginResponse(
    val user_id : String,
    val email : String,
    val password : String,
    val status: LoginStatus
)