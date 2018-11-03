package kz.darlogistics.courier2.room

import android.arch.persistence.room.*
import com.example.miras.magazine.entities.User
import io.reactivex.Maybe

@Dao
interface UserDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("SELECT * FROM users LIMIT 1")
    fun getUser() : Maybe<User>

    @Query("DELETE FROM users")
    fun delete()

}