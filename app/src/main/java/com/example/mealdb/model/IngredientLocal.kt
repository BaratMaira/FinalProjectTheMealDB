package com.example.mealdb.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredient")
data class IngredientLocal(
    @PrimaryKey
    @ColumnInfo(name = "idIngredient") val idIngredient: Int,
    @ColumnInfo(name = "strIngredient") val strIngredient: String,
    @ColumnInfo(name = "strDescription")val strDescription: String,
    @ColumnInfo(name = "strType")val strType: String
)