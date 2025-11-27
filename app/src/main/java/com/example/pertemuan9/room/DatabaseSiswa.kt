package com.example.pertemuan9.room

import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Siswa::class], version = 1, exportSchema = false)
abstract class DatabaseSiswa : RoomDatabase() {
    abstract fun siswaDao(): SiswaDao

    companion object {
        @Volatile
        private var Instance: DatabaseSiswa? = null

        fun getDatabase(context: Context): DatabaseSiswa {
            return (instance?: synchronized(this){
                room.databaseBuilder(
                    context,
                    DatabaseSiswa::class.java,
                    "siswa_database")
                    .build()
                    .also { Instance = it }
            })
        }

}


