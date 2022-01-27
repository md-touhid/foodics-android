package com.toptal.foodics.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by touhid on 26/Jan/2022.
 */
@Entity
data class Category(
    @PrimaryKey
    val id : String,
    val name : String
)