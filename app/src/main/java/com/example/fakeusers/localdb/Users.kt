package com.example.fakeusers.localdb

import android.content.Context
import android.provider.MediaStore
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName = "users_history")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0L,
    val name:String?,
    val image:String?,
    val email:String?,
    val number:String?,
)

@Dao
interface UsersDao{
    @Query("SELECT * FROM users_history")
    fun getData():LiveData<List<Users>>

    @Insert
    fun insert(item:Users)
}

@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase(){
    abstract val usersDao: UsersDao
    companion object {
        @Volatile
        private var INSTANCE: UsersDatabase? = null

        fun getInstance(context: Context): UsersDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        UsersDatabase::class.java,
                        "users_database_history"
                    ).fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}