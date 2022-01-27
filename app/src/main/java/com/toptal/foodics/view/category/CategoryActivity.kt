package com.toptal.foodics.view.category

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.toptal.foodics.view.product.ProductActivity
import android.app.Dialog
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.solver.widgets.Helper
import com.toptal.foodics.R


/**
 * A fragment representing a list of Items.
 */
class CategoryActivity : AppCompatActivity() {

    private val viewModel: CategoryViewModel by lazy {
        ViewModelProvider(this).get(CategoryViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_category)
        title = "Categories"

        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val intent = result.data
                openDialog(
                    intent?.getStringExtra("name")!!,
                    intent.getStringExtra("price")!!,
                    intent.getStringExtra("url")
                )
            }
        }
        val recyclerView: RecyclerView = findViewById(R.id.list)

        viewModel.getCategory {
            with(recyclerView) {
                layoutManager = LinearLayoutManager(context)
                adapter = CategoryRecyclerViewAdapter(it){
                    val intent = Intent(context,ProductActivity::class.java)
                    intent.putExtra("categoryId", it.id)
                    intent.putExtra("categoryName", it.name)
                    startForResult.launch(intent)
                }
            }
        }
    }

    fun openDialog(name: String, price: String, url: String?) {
        val dialog = Dialog(this) // Context, this, etc.
        dialog.setContentView(R.layout.item_product)
        dialog.setTitle(name)
        dialog.findViewById<TextView>(R.id.item_name).text = name
        dialog.findViewById<TextView>(R.id.item_price).text = price
        com.toptal.foodics.utils.Helper.loadImage(
            this,
            url,
            dialog.findViewById(R.id.item_image))
        dialog.show()
    }
}