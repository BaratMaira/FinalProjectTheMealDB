package com.example.mealdb.networking

import com.example.mealdb.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("random.php")
    suspend fun getRandom(): MealResponse

    @GET("categories.php")
    suspend fun getCategories(): CategoryResponse

    @GET("filter.php")
    suspend fun getFilterCategory(@Query("c") query: String): MealResponse

    @GET("lookup.php")
    suspend fun getFullDetails(@Query("i") id: Int) : MealResponse

    @GET("search.php")
    suspend fun getSearchByName(@Query("s") name: String) :MealResponse

    @GET("search.php")
    suspend fun getSearchByFirstLetter(@Query("f") letter:String) :MealResponse

    @GET("list.php")
    suspend fun getListArea(@Query("a") query:String): AreaResponse

    @GET("filter.php")
    suspend fun getFilterArea(@Query("a") query: String): MealResponse

    @GET("list.php")
    suspend fun getListIngredients(@Query("i") query: String):  IngredientResponse

    @GET("filter.php")
    suspend fun getFilterIngredients(@Query("i") query: String): MealResponse
}