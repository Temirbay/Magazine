package kz.darlogistics.courier2.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.example.miras.magazine.entities.Email
import io.reactivex.Maybe

@Dao
interface EmailDao{
    @Insert
    fun saveEmail(email: Email)

    @Query("SELECT * from emails LIMIT 1")
    fun getEmail(): Maybe<Email>

    @Query("DELETE from emails")
    fun deleteEmail()

}