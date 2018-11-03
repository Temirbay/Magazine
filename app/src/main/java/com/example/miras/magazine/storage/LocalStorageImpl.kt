package com.example.miras.magazine.storage

import com.example.miras.magazine.entities.Email
import com.example.miras.magazine.entities.User
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LocalStorageImpl(private val roomDb : AppLocalDatabase) : LocalStorage{


    private var user : User? = null

    override fun getUser(): Observable<User> {
        return roomDb.userDao().getUser().toObservable().map {
            this.user = it
            it
        }
    }

    override fun deleteUser() {
        this.user = null
        Observable.fromCallable { roomDb.userDao().delete() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    override fun getUserEmail(): Observable<String?> {
        return roomDb.emailDao().getEmail().toObservable().map {
            it.email
        }
    }

    override fun deleteEmail(): Observable<Unit> {
        return Observable.fromCallable { roomDb.emailDao().deleteEmail() }
    }

    override fun saveUser(user: User): Observable<Unit>? {
        return Observable.fromCallable { roomDb.userDao().insertUser(user)}
    }

    override fun saveEmail(email: String): Observable<Unit>? {
        return Observable.fromCallable { roomDb.emailDao().saveEmail(Email(email))}
    }

    override fun saveUserAndEmail(user: User, email: String) {
        this.user = user
        Observable.concat(
            deleteEmail(),
            saveUser(user),
            saveEmail(email)
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    override fun getUserId(): String?  = this.user?.id

}