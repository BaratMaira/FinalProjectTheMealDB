package com.example.mealdb.dataSource

import com.example.mealdb.model.*
import com.example.mealdb.networking.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.DisposableHandle
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiDataSource (
    private val apiClient: ApiClient
) {
    suspend fun loadRandomMeal(): MealResponse? {
        return withContext(Dispatchers.IO) {
            apiClient.getRandom()
        }
    }


    suspend fun loadCategory (): CategoryResponse? {
        return withContext(Dispatchers.IO) {
            apiClient.getCategories()
        }
    }

    suspend fun loadFilterCategory (name:String): MealResponse? {
        return withContext(Dispatchers.IO) {
            apiClient.getFilterCategory(name)
        }
    }

    suspend fun loadArea (name: String): AreaResponse? {
        return withContext(Dispatchers.IO) {
            apiClient.getListArea(name)
        }
    }

    suspend fun loadIngredient (name: String): IngredientResponse? {
        return withContext(Dispatchers.IO) {
            apiClient.getListIngredients(name)
        }
    }

    suspend fun loadFilterArea (name: String): MealResponse?{
        return withContext(Dispatchers.IO) {
            apiClient.getFilterArea(name)
        }
    }


    suspend fun loadFilterIngredient (name: String): MealResponse?{
        return withContext(Dispatchers.IO) {
            apiClient.getFilterIngredients(name)
        }
    }

    suspend fun loadMealDetail (id: Int): MealResponse? {
        return withContext(Dispatchers.IO) {
            apiClient.getFullDetails(id)
        }
    }

    suspend fun loadSearchByName (name: String) :MealResponse? {
        return withContext(Dispatchers.IO) {
            apiClient.getSearchByName(name)
        }
    }

    suspend fun loadSearchByFirstLetter (name: String): MealResponse?{
        return withContext(Dispatchers.IO) {
            apiClient.getSearchByFirstLetter(name)
        }
    }
}