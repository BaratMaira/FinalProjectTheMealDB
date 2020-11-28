package com.example.mealdb.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class CategoryLocal(
    @PrimaryKey
    @ColumnInfo(name = "idCategory") val idCategory: Int,
    @ColumnInfo(name = "strCategory") val strCategory: String,
    @ColumnInfo(name = "strCategoryThumb")val strCategoryThumb: String,
    @ColumnInfo(name = "strCategoryDescription")val strCategoryDescription: String
)