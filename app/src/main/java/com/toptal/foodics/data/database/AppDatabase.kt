package com.toptal.foodics.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.toptal.foodics.data.database.model.Category
import com.toptal.foodics.data.database.model.Product

/**
 * Created by touhid on 15/Aug/2021.
 */
@Database(entities = [Category::class, Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun productDao(): ProductDao
}