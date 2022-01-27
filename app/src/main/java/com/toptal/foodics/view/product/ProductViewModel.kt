package com.toptal.foodics.view.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toptal.foodics.data.database.DatabaseRepository
import com.toptal.foodics.data.database.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by touhid on 26/Jan/2022.
 */
class ProductViewModel: ViewModel() {

    val productDao = DatabaseRepository.db.productDao()

    fun getProducts(categoryId: String, callback: (List<Product>) -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            val products = productDao.getByCategory(categoryId)
            withContext(Dispatchers.Main){
                callback(products)
            }
        }
    }

}