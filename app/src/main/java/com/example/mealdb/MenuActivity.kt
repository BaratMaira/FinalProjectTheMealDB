package com.example.mealdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mealdb.adapter.AreaAdapter
import com.example.mealdb.adapter.CategoriesAdapter
import com.example.mealdb.adapter.RandomAdapter
import com.example.mealdb.dataSource.ApiDataSource
import com.example.mealdb.adapter.IngredientAdapter
import com.example.mealdb.dataSource.LocalDataSource
import com.example.mealdb.database.AppDatabase
import com.example.mealdb.model.*
import com.example.mealdb.networking.ApiFactory
import com.example.mealdb.repository.MealRepository
import com.example.mealdb.viewModel.Factory
import com.example.mealdb.viewModel.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.activity_menu.search

class MenuActivity : AppCompatActivity() {
    private var firebaseAuth = FirebaseAuth.getInstance()
    private var user = firebaseAuth.currentUser!!.uid

    private val viewModel by lazy{
        ViewModelProviders.of(this, Factory(
            ApiDataSource(ApiFactory.getApiClient())
        ))[ViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        search.setOnClickListener{
            startActivity(Intent(this, SearchByNameActivity::class.java))
        }

        sign_out.setOnClickListener{
            firebaseAuth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        initUi()
        initObservers()

    }

    private fun initUi(){

        recyclerView_latest.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView_categories.layoutManager = GridLayoutManager(this, 2)
        recyclerView_area.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView_ingredient.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        viewModel.loadRandomMeal()
        viewModel.loadCategory()
        val area = "list"
        viewModel.loadArea(area)
        viewModel.loadIngredient(area)
    }

    private fun initObservers(){
        viewModel.mealsLiveData.observe(this, Observer {
            setupData(it)
        })
        viewModel.categoryLiveData.observe(this, Observer {
            setupCategory(it)
        })
        viewModel.areaLiveData.observe(this, Observer {
            setupArea(it)
        })
        viewModel.ingredientLiveData.observe(this, Observer {
            setupIngredient(it)
        })
    }

    private fun setupData(meals: List<Meal>) {
        recyclerView_latest!!.adapter =
            RandomAdapter(meals  as ArrayList<Meal>, onMealClick = {
                val intent = Intent(this, MealDetailActivity::class.java)
                intent.putExtra("idMeal" , it.idMeal)
                startActivity(intent)
            })
    }

    private fun setupCategory(categories: List<Category>) {
        recyclerView_categories!!.adapter =
            CategoriesAdapter(categories as ArrayList<Category>, onMealClick = {
                val intent = Intent(this, CategoryActivity::class.java)
                intent.putExtra("idCategory", it.idCategory)
                intent.putExtra("strCategory", it.strCategory)
                intent.putExtra("strCategoryThumb", it.strCategoryThumb)
                intent.putExtra("strCategoryDescription", it.strCategoryDescription)
                startActivity(intent)
            })
    }

    private fun setupArea(meals: List<Area>){
        recyclerView_area!!.adapter =
            AreaAdapter(meals as ArrayList<Area>, onMealClick = {
                val intent = Intent(this@MenuActivity, FilterAreaActivity::class.java)
                intent.putExtra("strArea", it.strArea)
                startActivity(intent)
            })
    }

    private fun setupIngredient(meals: List<Ingredient>){
        recyclerView_ingredient!!.adapter =
            IngredientAdapter(
                meals as ArrayList<Ingredient>,
                onMealClick = {
                    val intent = Intent(this@MenuActivity, FilterIngredientActivity::class.java)
                    intent.putExtra("idIngredient", it.idIngredient)
                    intent.putExtra("strIngredient", it.strIngredient)
                    intent.putExtra("strDescription", it.strDescription)
                    intent.putExtra("strType", it.strType)
                    startActivity(intent)
                })
    }
}
