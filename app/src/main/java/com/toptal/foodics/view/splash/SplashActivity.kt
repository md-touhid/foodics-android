package com.toptal.foodics.view.splash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.toptal.foodics.R
import com.toptal.foodics.data.database.DatabaseRepository
import com.toptal.foodics.view.category.CategoryActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext
import android.widget.Toast

import android.content.DialogInterface
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog


class SplashActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this).get(SplashViewModel::class.java)
    }

    val pref : SharedPreferences by lazy{
        getSharedPreferences("myPref", Context.MODE_PRIVATE)
    }

    var isDataLoaded: Boolean
        get() = pref.getBoolean("isDataLoaded",false)
        set(value) {
            pref.edit().putBoolean("isDataLoaded", value).apply()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        DatabaseRepository.init(applicationContext)
        tryLoadingData()
    }

    private fun tryLoadingData(){
        if(isDataLoaded){
            lifecycleScope.launch(Dispatchers.Default) {
                delay(200)
                launch(Dispatchers.Main) {
                    showCategoryListActivity()
                }
            }
            return
        }
        findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE

        viewModel.loadData{
            if(it) {
                isDataLoaded = true
                showCategoryListActivity()
            }
            //error, try again
            else{
                showAlert()
            }
        }
    }
    private fun showCategoryListActivity() {
        startActivity(Intent(this, CategoryActivity::class.java))
        finish()
    }

    private fun showAlert(){
        findViewById<ProgressBar>(R.id.loader).visibility = View.INVISIBLE
        AlertDialog.Builder(this) //set icon
            .setIcon(android.R.drawable.ic_dialog_alert) //set title
            .setTitle("Try Again") //set message
            .setMessage("Data loading failed. Do you want to try again?")
            .setPositiveButton("Yes") { _, _ ->
                tryLoadingData()
            }
            .setNegativeButton("Exit") { _, _ ->
                finish()
            }
            .show()

    }
}