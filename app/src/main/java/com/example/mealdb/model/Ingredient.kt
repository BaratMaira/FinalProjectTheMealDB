package com.example.mealdb.model

data class Ingredient (
    val idIngredient: Int,
    val strIngredient: String,
    val strDescription:String,
    val strType: String
)

data class IngredientResponse(
    val meals: List<Ingredient>
)