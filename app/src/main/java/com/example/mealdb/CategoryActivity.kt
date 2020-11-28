package com.example.mealdb

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mealdb.adapter.FilterCategoryAdapter
import com.example.mealdb.dataSource.ApiDataSource
import com.example.mealdb.dataSource.LocalDataSource
import com.example.mealdb.database.AppDatabase
import com.example.mealdb.model.Meal
import com.example.mealdb.networking.ApiFactory
import com.example.mealdb.repository.MealRepository
import com.example.mealdb.viewModel.Factory
import com.example.mealdb.viewModel.ViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.toolbar.*

class CategoryActivity : AppCompatActivity() {
    private val viewModel by lazy{
        ViewModelProviders.of(this, Factory(
            ApiDataSource(ApiFactory.getApiClient())
        ))[ViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        setSupportActionBar(toolbar)
        val displayHomeAsUpEnabled = supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initUi()
        initObservers()
    }

    private fun initUi(){
        recyclerView_filterCategories.layoutManager = GridLayoutManager(this, 2)
        val strCategory = intent.getStringExtra("strCategory")
        textView_title.text = intent.getStringExtra("strCategory")
        val categoryThumb = intent.getStringExtra("strCategoryThumb")
        Picasso.get().load(categoryThumb).into(image_meal)
        textView_description.text = intent.getStringExtra("strCategoryDescription")
        viewModel.loadFilterCategory(strCategory)
    }

    private fun initObservers(){
        viewModel.filterCategoryLiveData.observe(this, Observer {
            setupFilterCategory(it)
        })
    }

    private fun setupFilterCategory(category: List<Meal>) {
        recyclerView_filterCategories!!.adapter =
            FilterCategoryAdapter(category as ArrayList<Meal>, onMealClick = {
                val intent = Intent(this@CategoryActivity, MealDetailActivity::class.java)
                intent.putExtra("idMeal", it.idMeal)
                intent.putExtra("strMeal", it.strMeal)
                intent.putExtra("strCategory", it.strCategory)
                intent.putExtra("strArea", it.strArea)
                intent.putExtra("strYoutube", it.strYoutube)
                intent.putExtra("strMealThumb", it.strMealThumb)
                intent.putExtra("strInstructions", it.strInstructions)
                intent.putExtra("strIngredient1", it.strIngredient1)
                intent.putExtra("strIngredient2", it.strIngredient2)
                intent.putExtra("strIngredient3", it.strIngredient3)
                intent.putExtra("strIngredient4", it.strIngredient4)
                intent.putExtra("strIngredient5", it.strIngredient5)
                intent.putExtra("strIngredient6", it.strIngredient6)
                intent.putExtra("strIngredient7", it.strIngredient7)
                intent.putExtra("strIngredient8", it.strIngredient8)
                intent.putExtra("strIngredient9", it.strIngredient9)
                intent.putExtra("strIngredient10", it.strIngredient10)
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
