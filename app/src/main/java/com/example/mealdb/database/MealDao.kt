package com.example.mealdb.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mealdb.model.MealLocal

@Dao
interface MealDao{

    @Insert
    fun insertMeal(mealLocal: MealLocal)

    @Query("SELECT *FROM meal")
    fun getMealList(): List<MealLocal>

}