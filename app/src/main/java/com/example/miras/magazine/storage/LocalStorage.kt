package com.example.miras.magazine.storage

import com.example.miras.magazine.entities.User
import io.reactivex.Observable

interface LocalStorage {

    fun getUser() : Observable<User>

    fun deleteUser()

    fun getUserEmail() : Observable<String?>

    fun deleteEmail(): Observable<Unit>

    fun saveUser(user: User): Observable<Unit>?

    fun saveEmail(email: String): Observable<Unit>?

    fun saveUserAndEmail(user: User, email: String)

    fun getUserId() : String?
}