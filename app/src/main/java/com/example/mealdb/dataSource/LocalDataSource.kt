package com.example.mealdb.dataSource

import android.os.AsyncTask
import com.example.mealdb.database.AreaDao
import com.example.mealdb.database.CategoryDao
import com.example.mealdb.database.IngredientDao
import com.example.mealdb.database.MealDao
import com.example.mealdb.model.AreaLocal
import com.example.mealdb.model.CategoryLocal
import com.example.mealdb.model.IngredientLocal
import com.example.mealdb.model.MealLocal

class LocalDataSource (
    private val mealDao: MealDao,
    private val categoryDao: CategoryDao,
    private val areaDao: AreaDao,
    private val ingredientDao: IngredientDao
){
    fun loadRandomMeal(onComplete: (List<MealLocal>) -> Unit){
        AsyncTask.execute{
            val meals = mealDao.getMealList()
        }
    }

    fun loadCategory (onComplete: (List<CategoryLocal>) -> Unit){
        AsyncTask.execute{
            val category = categoryDao.getCategory()
            onComplete(category)
        }
    }

    fun loadFilterCategory (onComplete: (List<MealLocal>) -> Unit){
        AsyncTask.execute{
            val filterCategory = mealDao.getMealList()
            onComplete(filterCategory)
        }
    }

    fun loadArea (onComplete: (List<AreaLocal>) -> Unit){
        AsyncTask.execute{
            val area = areaDao.getAreaList()
            onComplete(area)
        }
    }

    fun loadFilterArea (onComplete: (List<MealLocal>) -> Unit){
        AsyncTask.execute{
            val area = mealDao.getMealList()
            onComplete(area)
        }
    }

    fun loadIngredient (onComplete: (List<IngredientLocal>) -> Unit){
        AsyncTask.execute{
            val ingredient = ingredientDao.getIngredient()
            onComplete(ingredient)
        }
    }


    fun loadFilterIngredient (onComplete: (List<MealLocal>) -> Unit){
        AsyncTask.execute{
            val ingredient = mealDao.getMealList()
            onComplete(ingredient)
        }
    }

    fun loadMealDetail (onComplete: (List<MealLocal>) -> Unit){
        AsyncTask.execute{
            val ingredient = mealDao.getMealList()
            onComplete(ingredient)
        }
    }

    fun loadSearchByName (onComplete: (List<MealLocal>) -> Unit){
        AsyncTask.execute{
            val ingredient = mealDao.getMealList()
            onComplete(ingredient)
        }
    }

    fun loadSearchByFirstLetter (onComplete: (List<MealLocal>) -> Unit){
        AsyncTask.execute{
            val ingredient = mealDao.getMealList()
            onComplete(ingredient)
        }
    }

        fun cacheMeals(meals: List<MealLocal>){
        AsyncTask.execute{
            meals.forEach{
                mealDao.insertMeal(it)
            }
        }
    }
//
//    fun cacheCategory(categories: List<CategoryLocal>) {
//        AsyncTask.execute {
//            categories.forEach {
//                categoryDao.insertCategory(it)
//            }
//        }
//    }
}