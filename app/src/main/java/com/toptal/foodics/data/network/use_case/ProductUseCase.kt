package com.toptal.foodics.data.network.use_case

import com.toptal.foodics.data.network.FoodicsRepository

/**
 * Created by touhid on 24/Jan/2022.
 */
class ProductUseCase {

    suspend fun loadProducts() = FoodicsRepository.service.getProducts().data
}