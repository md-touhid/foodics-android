package com.toptal.foodics.data.network

import com.toptal.foodics.data.network.model.response.CategoryResponse
import com.toptal.foodics.data.network.model.response.ProductResponse
import retrofit2.http.*

/**
 * Created by touhid on 24/Jan/2022.
 */

interface ApiService {

    @GET("categories")
    suspend fun getCategories(): CategoryResponse

    @GET("products?include=category")
    suspend fun getProducts(): ProductResponse
}