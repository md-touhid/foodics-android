package com.toptal.foodics.view.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toptal.foodics.data.database.DatabaseRepository
import com.toptal.foodics.data.database.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Created by touhid on 26/Jan/2022.
 */
class CategoryViewModel: ViewModel() {

    val categoryDao = DatabaseRepository.db.categoryDao()

    fun getCategory(callback: (List<Category>) -> Unit){
        viewModelScope.launch(Dispatchers.IO){
            val categories = categoryDao.getAll()
            withContext(Dispatchers.Main){
                callback(categories)
            }
        }
    }

}