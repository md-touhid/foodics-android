package com.toptal.foodics.data.network.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by touhid on 24/Jan/2022.
 */
data class Category(
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String
)
