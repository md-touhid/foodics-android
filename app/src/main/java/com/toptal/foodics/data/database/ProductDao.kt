package com.toptal.foodics.data.database

import androidx.room.*

/**
 * Created by touhid on 15/Aug/2021.
 */
@Dao
interface ProductDao {

    @Query("SELECT * FROM product where category_id=:categoryId")
    fun getByCategory(categoryId: String) : List<com.toptal.foodics.data.database.model.Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(categories: List<com.toptal.foodics.data.database.model.Product>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(categories: com.toptal.foodics.data.database.model.Product)

    @Query("DELETE FROM product")
    fun drop()
}