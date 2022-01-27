package com.toptal.foodics.view.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toptal.foodics.data.database.DatabaseRepository
import com.toptal.foodics.data.database.model.Category
import com.toptal.foodics.data.database.model.Product
import com.toptal.foodics.data.network.use_case.CategoryUseCase
import com.toptal.foodics.data.network.use_case.ProductUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by touhid on 24/Jan/2022.
 */
class SplashViewModel: ViewModel() {

    val categoryUseCase = CategoryUseCase()
    val productUseCase = ProductUseCase()
    val categoryDao = DatabaseRepository.db.categoryDao()
    val productDao = DatabaseRepository.db.productDao()

    fun loadData(callback: (Boolean) -> Unit) {
        viewModelScope.launch {

            try {
                val categories = categoryUseCase.loadCategory()
                val products = productUseCase.loadProducts()

                withContext(Dispatchers.IO) {
                    categories.forEach {
                        categoryDao.insert(Category(it.id, it.name))
                    }
                    products.forEach {
                        productDao.insert(
                            Product(
                                it.id,
                                it.name,
                                it.image,
                                it.price,
                                it.cost,
                                it.category.id
                            )
                        )
                    }
                    //success
                    callback(true)
                }
            }
            catch (e: Exception){
                e.printStackTrace()
                //failure
                callback(false)
            }
        }
    }
}