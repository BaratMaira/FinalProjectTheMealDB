package com.example.mealdb

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mealdb.adapter.FilterAreaAdapter
import com.example.mealdb.dataSource.ApiDataSource
import com.example.mealdb.dataSource.LocalDataSource
import com.example.mealdb.database.AppDatabase
import com.example.mealdb.model.Meal
import com.example.mealdb.networking.ApiFactory
import com.example.mealdb.repository.MealRepository
import com.example.mealdb.viewModel.Factory
import com.example.mealdb.viewModel.ViewModel
import kotlinx.android.synthetic.main.activity_filter_area.*
import kotlinx.android.synthetic.main.toolbar.*

class FilterAreaActivity : AppCompatActivity() {

    private val viewModel by lazy{
        ViewModelProviders.of(this, Factory(
            ApiDataSource(ApiFactory.getApiClient())
        ))[ViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_area)

        setSupportActionBar(toolbar)
        val displayHomeAsUpEnabled = supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initUi()
        initObservers()

    }

    private fun initUi(){
        recyclerView_filterArea.layoutManager = GridLayoutManager(this, 2)
        val strArea = intent.getStringExtra("strArea")
        textView_area.text = strArea
        viewModel.loadFilterArea(strArea)
    }

    private fun initObservers(){
        viewModel.filterAreaLiveData.observe(this, Observer {
            setupFilterArea(it)
        })
    }

    private fun setupFilterArea(area: List<Meal>) {
        recyclerView_filterArea!!.adapter =
            FilterAreaAdapter(area as ArrayList<Meal>, onMealClick = {
                val intent = Intent(this@FilterAreaActivity, MealDetailActivity::class.java)
                intent.putExtra("idMeal", it.idMeal)
                startActivity(intent)
            })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setResult(Activity.RESULT_CANCELED)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
