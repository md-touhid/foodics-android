package com.toptal.foodics.data.database

import androidx.room.*

/**
 * Created by touhid on 15/Aug/2021.
 */
@Dao
interface CategoryDao {

    @Query("SELECT * FROM category")
    fun getAll() : List<com.toptal.foodics.data.database.model.Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(categories: List<com.toptal.foodics.data.database.model.Category>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: com.toptal.foodics.data.database.model.Category)

    @Query("DELETE FROM category")
    fun drop()
}