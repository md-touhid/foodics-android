package com.toptal.foodics.data.database

import android.content.Context
import androidx.room.Room

/**
 * Created by touhid on 15/Aug/2021.
 */
object DatabaseRepository {

    lateinit var db : AppDatabase

    fun init(context: Context){
        db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "roomDb"
        ).build()
    }
}