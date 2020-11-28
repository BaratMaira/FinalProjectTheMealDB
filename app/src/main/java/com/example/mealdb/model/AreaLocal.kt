package com.example.mealdb.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "area")
data class AreaLocal(
    @PrimaryKey
    @ColumnInfo(name = "strArea") val strArea: String
)