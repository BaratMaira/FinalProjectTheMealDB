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
import com.example.mealdb.adapter.FilterIngredientAdapter
import com.example.mealdb.dataSource.ApiDataSource
import com.example.mealdb.dataSource.LocalDataSource
import com.example.mealdb.database.AppDatabase
import com.example.mealdb.model.Meal
import com.example.mealdb.networking.ApiFactory
import com.example.mealdb.repository.MealRepository
import com.example.mealdb.viewModel.Factory
import com.example.mealdb.viewModel.ViewModel
import kotlinx.android.synthetic.main.activity_filter_area.*
import kotlinx.android.synthetic.main.activity_filter_ingredient.*
import kotlinx.android.synthetic.main.toolbar.*

class FilterIngredientActivity : AppCompatActivity() {

    private val viewModel by lazy{
        ViewModelProviders.of(this, Factory(
            ApiDataSource(ApiFactory.getApiClient())
        ))[ViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_ingredient)

        setSupportActionBar(toolbar)
        val displayHomeAsUpEnabled = supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initUi()
        initObservers()
    }

    private fun initUi(){
        recyclerView_filterIngredients.layoutManager = GridLayoutManager(this, 2)
        val strIngredient = intent.getStringExtra("strIngredient")
        val strDescription = intent.getStringExtra("strDescription")
        textView_title.text = strIngredient
        textView_description.text = strDescription
        viewModel.loadFilterIngredient(strIngredient)
    }

    private fun initObservers(){
        viewModel.filterIngredientLiveData.observe(this, Observer {
            setupFilterIngredient(it)
        })
    }

    private fun setupFilterIngredient(area: List<Meal>) {
        recyclerView_filterIngredients!!.adapter =
            FilterIngredientAdapter(area as ArrayList<Meal>, onMealClick = {
                val intent = Intent(this@FilterIngredientActivity, MealDetailActivity::class.java)
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
