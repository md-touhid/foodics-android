package com.toptal.foodics.data.database.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by touhid on 24/Jan/2022.
 */
@Entity
data class Product(
    @PrimaryKey
    val id : String,
    val name : String,
    val image : String?,
    val price : Double,
    val cost : Double,
    val category_id: String
)