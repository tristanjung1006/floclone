package com.example.floclone

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.floclone.data.entities.Song
import com.example.floclone.data.entities.User


@Database(entities = [Song::class, User::class], version = 1)
abstract class SongDatabase: RoomDatabase() {
    abstract fun songDao(): SongDao
    abstract fun userDao(): UserDao

    companion object {
        private var instance: SongDatabase? = null

        @Synchronized
        fun getInstance(context: Context): SongDatabase? {
            if (instance == null) {
                synchronized(SongDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SongDatabase::class.java,
                        "song-database"//다른 데이터 베이스랑 이름겹치면 꼬임
                    ).allowMainThreadQueries().build()
                }
            }

            return instance
        }
    }
}
