package com.toptal.foodics.view.product

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.toptal.foodics.R
import android.content.Intent
import android.widget.Toast

/**
 * A fragment representing a list of Items.
 */
class ProductActivity : AppCompatActivity() {

    private val viewModel: ProductViewModel by lazy {
        ViewModelProvider(this).get(ProductViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val categoryId = intent.extras?.get("categoryId") as String
        val categoryName = intent.extras?.get("categoryName") as String
        title = categoryName

        val recyclerView: RecyclerView = findViewById(R.id.list)

        viewModel.getProducts(categoryId) {
            if(it.isEmpty())
                Toast.makeText(this, "Empty!", Toast.LENGTH_LONG).show()
            with(recyclerView) {
                layoutManager = LinearLayoutManager(context)
                adapter = ProductRecyclerViewAdapter(it){
                    val returnIntent = Intent()
                    returnIntent.putExtra("name", it.name)
                    returnIntent.putExtra("url", it.image)
                    returnIntent.putExtra("price", it.price.toString())
                    setResult(RESULT_OK, returnIntent)
                    finish()
                }
            }
        }
    }
}