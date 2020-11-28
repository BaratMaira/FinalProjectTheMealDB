package com.example.mealdb.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mealdb.model.CategoryLocal

@Dao
interface CategoryDao{

    @Insert
    fun insertCategory(categoryLocal: CategoryLocal)

    @Query("SELECT *FROM category")
    fun getCategory(): List<CategoryLocal>
}