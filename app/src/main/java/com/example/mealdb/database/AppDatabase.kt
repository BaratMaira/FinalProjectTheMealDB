package com.example.mealdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mealdb.model.AreaLocal
import com.example.mealdb.model.CategoryLocal
import com.example.mealdb.model.IngredientLocal
import com.example.mealdb.model.MealLocal

@Database(entities = [MealLocal::class, CategoryLocal::class, AreaLocal::class, IngredientLocal::class], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDao(): MealDao
    abstract fun getCategoryDao(): CategoryDao
    abstract fun getAreaDao(): AreaDao
    abstract fun getIngredientDao(): IngredientDao


    companion object {
        private const val DB_NAME = "app.db"
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, DB_NAME
                ).fallbackToDestructiveMigration().build()
            }
            return instance
        }
    }
}