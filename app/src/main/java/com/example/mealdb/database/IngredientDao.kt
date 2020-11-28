package com.example.mealdb.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mealdb.model.IngredientLocal

@Dao
interface IngredientDao{

    @Insert
    fun insertIngredient(ingredientLocal: IngredientLocal)

    @Query("SELECT *FROM ingredient")
    fun getIngredient(): List<IngredientLocal>

}