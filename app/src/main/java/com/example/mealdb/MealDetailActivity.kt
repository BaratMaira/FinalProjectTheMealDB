package com.example.mealdb

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealdb.adapter.MealDetailAdapter
import com.example.mealdb.adapter.RandomAdapter
import com.example.mealdb.dataSource.ApiDataSource
import com.example.mealdb.dataSource.LocalDataSource
import com.example.mealdb.database.AppDatabase
import com.example.mealdb.model.Meal
import com.example.mealdb.networking.ApiFactory
import com.example.mealdb.repository.MealRepository
import com.example.mealdb.viewModel.Factory
import com.example.mealdb.viewModel.ViewModel
import kotlinx.android.synthetic.main.activity_meal_detail.*
import kotlinx.android.synthetic.main.toolbar.*

class MealDetailActivity : AppCompatActivity() {
    private val viewModel by lazy{
        ViewModelProviders.of(this, Factory(
            ApiDataSource(ApiFactory.getApiClient())
        ))[ViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_detail)

        setSupportActionBar(toolbar)
        val displayHomeAsUpEnabled = supportActionBar?.setDisplayHomeAsUpEnabled(true)
        initUi()
        initObservers()
    }

    private fun initUi(){

        recyclerView_detail.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val id = intent.getIntExtra("idMeal",0)
        viewModel.loadMealDetail(id)
    }

    private fun initObservers(){
        viewModel.mealDetailLiveData.observe(this, Observer {
            setupData(it)
        })

    }

    private fun setupData(meals: List<Meal>) {
        recyclerView_detail!!.adapter =
            MealDetailAdapter(meals  as ArrayList<Meal>)
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
