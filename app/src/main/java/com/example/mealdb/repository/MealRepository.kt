package com.example.mealdb.repository

import com.example.mealdb.dataSource.ApiDataSource
import com.example.mealdb.dataSource.LocalDataSource
import com.example.mealdb.model.*

class MealRepository (
    private val apiDataSource: ApiDataSource,
    private val localDataSource: LocalDataSource
){
//    fun loadRandomMeal(){
//        apiDataSource.loadRandomMeal {
//            mealResponse ->
//            if (mealResponse == null){
//                localDataSource.loadRandomMeal {
//                    onSuccess(
//                        MealResponse(
//                            meals = it.map { mealLocal ->
//                                Meal(
//                                    idMeal = mealLocal.idMeal,
//                                    strMeal = mealLocal.strMeal,
//                                    strArea = mealLocal.strArea,
//                                    strCategory = mealLocal.strCategory,
//                                    strIngredient1 = mealLocal.strIngredient1,
//                                    strIngredient2 = mealLocal.strIngredient2,
//                                    strIngredient3 = mealLocal.strIngredient3,
//                                    strIngredient4 = mealLocal.strIngredient4,
//                                    strIngredient5 = mealLocal.strIngredient5,
//                                    strIngredient6 = mealLocal.strIngredient6,
//                                    strIngredient7 = mealLocal.strIngredient7,
//                                    strIngredient8 = mealLocal.strIngredient8,
//                                    strIngredient9 = mealLocal.strIngredient9,
//                                    strIngredient10 = mealLocal.strIngredient10,
//                                    strIngredient11 = mealLocal.strIngredient11,
//                                    strIngredient12 = mealLocal.strIngredient12,
//                                    strIngredient13 = mealLocal.strIngredient13,
//                                    strIngredient14 = mealLocal.strIngredient14,
//                                    strIngredient15 = mealLocal.strIngredient15,
//                                    strIngredient16 = mealLocal.strIngredient16,
//                                    strIngredient17 = mealLocal.strIngredient17,
//                                    strIngredient18 = mealLocal.strIngredient18,
//                                    strIngredient19 = mealLocal.strIngredient19,
//                                    strIngredient20 = mealLocal.strIngredient20,
//                                    strInstructions = mealLocal.strInstructions,
//                                    strMealThumb = mealLocal.strMealThumb,
//                                    strMeasure1 = mealLocal.strMeasure1,
//                                    strMeasure2 = mealLocal.strMeasure2,
//                                    strMeasure3 = mealLocal.strMeasure3,
//                                    strMeasure4 = mealLocal.strMeasure4,
//                                    strMeasure5 = mealLocal.strMeasure5,
//                                    strMeasure6 = mealLocal.strMeasure6,
//                                    strMeasure7 = mealLocal.strMeasure7,
//                                    strMeasure8 = mealLocal.strMeasure8,
//                                    strMeasure9 = mealLocal.strMeasure9,
//                                    strMeasure10 = mealLocal.strMeasure10,
//                                    strMeasure11 = mealLocal.strMeasure11,
//                                    strMeasure12 = mealLocal.strMeasure12,
//                                    strMeasure13 = mealLocal.strMeasure13,
//                                    strMeasure14 = mealLocal.strMeasure14,
//                                    strMeasure15 = mealLocal.strMeasure15,
//                                    strMeasure16 = mealLocal.strMeasure16,
//                                    strMeasure17 = mealLocal.strMeasure17,
//                                    strMeasure18 = mealLocal.strMeasure18,
//                                    strMeasure19 = mealLocal.strMeasure19,
//                                    strMeasure20 = mealLocal.strMeasure20,
//                                    strTags = mealLocal.strTags,
//                                    strYoutube = mealLocal.strYoutube
//                                )
//                            }
//                        )
//                    )
//                }
//            }else{
//                onSuccess(mealResponse)
//            }
//        }
//    }

//    fun loadCategory(
//        onSuccess:(CategoryResponse) -> Unit
//    ) {
//        apiDataSource.loadCategory { categoryResponse ->
//            if (categoryResponse == null) {
//                localDataSource.loadCategory {
//                    onSuccess(
//                        CategoryResponse(
//                            categories = it.map { categoryLocal ->
//                                Category(
//                                    idCategory = categoryLocal.idCategory,
//                                    strCategory = categoryLocal.strCategory,
//                                    strCategoryThumb = categoryLocal.strCategoryThumb,
//                                    strCategoryDescription = categoryLocal.strCategoryDescription
//                                )
//                            }
//                        )
//                    )
//                }
//            } else {
//                onSuccess(categoryResponse)
//            }
//        }
//    }

//    fun loadFilterCategory(
//        name: String,
//        onSuccess:(MealResponse) -> Unit
//    ){
//        apiDataSource.loadFilterCategory(name) {
//                mealResponse ->
//            if (mealResponse == null){
//                localDataSource.loadFilterCategory {
//                    onSuccess(
//                        MealResponse(
//                            meals = it.map { mealLocal ->
//                                Meal(
//                                    idMeal = mealLocal.idMeal,
//                                    strMeal = mealLocal.strMeal,
//                                    strArea = mealLocal.strArea,
//                                    strCategory = mealLocal.strCategory,
//                                    strIngredient1 = mealLocal.strIngredient1,
//                                    strIngredient2 = mealLocal.strIngredient2,
//                                    strIngredient3 = mealLocal.strIngredient3,
//                                    strIngredient4 = mealLocal.strIngredient4,
//                                    strIngredient5 = mealLocal.strIngredient5,
//                                    strIngredient6 = mealLocal.strIngredient6,
//                                    strIngredient7 = mealLocal.strIngredient7,
//                                    strIngredient8 = mealLocal.strIngredient8,
//                                    strIngredient9 = mealLocal.strIngredient9,
//                                    strIngredient10 = mealLocal.strIngredient10,
//                                    strIngredient11 = mealLocal.strIngredient11,
//                                    strIngredient12 = mealLocal.strIngredient12,
//                                    strIngredient13 = mealLocal.strIngredient13,
//                                    strIngredient14 = mealLocal.strIngredient14,
//                                    strIngredient15 = mealLocal.strIngredient15,
//                                    strIngredient16 = mealLocal.strIngredient16,
//                                    strIngredient17 = mealLocal.strIngredient17,
//                                    strIngredient18 = mealLocal.strIngredient18,
//                                    strIngredient19 = mealLocal.strIngredient19,
//                                    strIngredient20 = mealLocal.strIngredient20,
//                                    strInstructions = mealLocal.strInstructions,
//                                    strMealThumb = mealLocal.strMealThumb,
//                                    strMeasure1 = mealLocal.strMeasure1,
//                                    strMeasure2 = mealLocal.strMeasure2,
//                                    strMeasure3 = mealLocal.strMeasure3,
//                                    strMeasure4 = mealLocal.strMeasure4,
//                                    strMeasure5 = mealLocal.strMeasure5,
//                                    strMeasure6 = mealLocal.strMeasure6,
//                                    strMeasure7 = mealLocal.strMeasure7,
//                                    strMeasure8 = mealLocal.strMeasure8,
//                                    strMeasure9 = mealLocal.strMeasure9,
//                                    strMeasure10 = mealLocal.strMeasure10,
//                                    strMeasure11 = mealLocal.strMeasure11,
//                                    strMeasure12 = mealLocal.strMeasure12,
//                                    strMeasure13 = mealLocal.strMeasure13,
//                                    strMeasure14 = mealLocal.strMeasure14,
//                                    strMeasure15 = mealLocal.strMeasure15,
//                                    strMeasure16 = mealLocal.strMeasure16,
//                                    strMeasure17 = mealLocal.strMeasure17,
//                                    strMeasure18 = mealLocal.strMeasure18,
//                                    strMeasure19 = mealLocal.strMeasure19,
//                                    strMeasure20 = mealLocal.strMeasure20,
//                                    strTags = mealLocal.strTags,
//                                    strYoutube = mealLocal.strYoutube
//                                )
//                            }
//                        )
//                    )
//                }
//            }else{
//                onSuccess(mealResponse)
//            }
//        }
//    }

//    fun loadArea(
//        name:String,
//        onSuccess:(AreaResponse) -> Unit
//    ) {
//        apiDataSource.loadArea(name) { areaResponse ->
//            if (areaResponse == null) {
//                localDataSource.loadArea {
//                    onSuccess(
//                        AreaResponse(
//                            meals = it.map { areaLocal ->
//                                Area(
//                                    strArea = areaLocal.strArea
//                                    )
//                            }
//                        )
//                    )
//                }
//            } else {
//                onSuccess(areaResponse)
//            }
//        }
//    }
//
//    fun loadFilterArea(name: String,
//        onSuccess:(MealResponse) -> Unit
//    ){
//        apiDataSource.loadFilterArea(name) {
//                mealResponse ->
//            if (mealResponse == null){
//                localDataSource.loadFilterArea {
//                    onSuccess(
//                        MealResponse(
//                            meals = it.map { mealLocal ->
//                                Meal(
//                                    idMeal = mealLocal.idMeal,
//                                    strMeal = mealLocal.strMeal,
//                                    strArea = mealLocal.strArea,
//                                    strCategory = mealLocal.strCategory,
//                                    strIngredient1 = mealLocal.strIngredient1,
//                                    strIngredient2 = mealLocal.strIngredient2,
//                                    strIngredient3 = mealLocal.strIngredient3,
//                                    strIngredient4 = mealLocal.strIngredient4,
//                                    strIngredient5 = mealLocal.strIngredient5,
//                                    strIngredient6 = mealLocal.strIngredient6,
//                                    strIngredient7 = mealLocal.strIngredient7,
//                                    strIngredient8 = mealLocal.strIngredient8,
//                                    strIngredient9 = mealLocal.strIngredient9,
//                                    strIngredient10 = mealLocal.strIngredient10,
//                                    strIngredient11 = mealLocal.strIngredient11,
//                                    strIngredient12 = mealLocal.strIngredient12,
//                                    strIngredient13 = mealLocal.strIngredient13,
//                                    strIngredient14 = mealLocal.strIngredient14,
//                                    strIngredient15 = mealLocal.strIngredient15,
//                                    strIngredient16 = mealLocal.strIngredient16,
//                                    strIngredient17 = mealLocal.strIngredient17,
//                                    strIngredient18 = mealLocal.strIngredient18,
//                                    strIngredient19 = mealLocal.strIngredient19,
//                                    strIngredient20 = mealLocal.strIngredient20,
//                                    strInstructions = mealLocal.strInstructions,
//                                    strMealThumb = mealLocal.strMealThumb,
//                                    strMeasure1 = mealLocal.strMeasure1,
//                                    strMeasure2 = mealLocal.strMeasure2,
//                                    strMeasure3 = mealLocal.strMeasure3,
//                                    strMeasure4 = mealLocal.strMeasure4,
//                                    strMeasure5 = mealLocal.strMeasure5,
//                                    strMeasure6 = mealLocal.strMeasure6,
//                                    strMeasure7 = mealLocal.strMeasure7,
//                                    strMeasure8 = mealLocal.strMeasure8,
//                                    strMeasure9 = mealLocal.strMeasure9,
//                                    strMeasure10 = mealLocal.strMeasure10,
//                                    strMeasure11 = mealLocal.strMeasure11,
//                                    strMeasure12 = mealLocal.strMeasure12,
//                                    strMeasure13 = mealLocal.strMeasure13,
//                                    strMeasure14 = mealLocal.strMeasure14,
//                                    strMeasure15 = mealLocal.strMeasure15,
//                                    strMeasure16 = mealLocal.strMeasure16,
//                                    strMeasure17 = mealLocal.strMeasure17,
//                                    strMeasure18 = mealLocal.strMeasure18,
//                                    strMeasure19 = mealLocal.strMeasure19,
//                                    strMeasure20 = mealLocal.strMeasure20,
//                                    strTags = mealLocal.strTags,
//                                    strYoutube = mealLocal.strYoutube
//                                )
//                            }
//                        )
//                    )
//                }
//            }else{
//                onSuccess(mealResponse)
//            }
//        }
//    }

//    fun loadIngredient(
//        name:String,
//        onSuccess:(IngredientResponse) -> Unit
//    ) {
//        apiDataSource.loadIngredient(name) { ingredientResponse ->
//            if (ingredientResponse == null) {
//                localDataSource.loadIngredient {
//                    onSuccess(
//                        IngredientResponse(
//                            meals = it.map { ingredientLocal ->
//                                Ingredient(
//                                    idIngredient = ingredientLocal.idIngredient,
//                                    strIngredient = ingredientLocal.strIngredient,
//                                    strDescription = ingredientLocal.strDescription,
//                                    strType = ingredientLocal.strType
//                                )
//                            }
//                        )
//                    )
//                }
//            } else {
//                onSuccess(ingredientResponse)
//            }
//        }
//    }

//    fun loadFilterIngredient(name: String,
//                       onSuccess:(MealResponse) -> Unit
//    ){
//        apiDataSource.loadFilterIngredient(name) {
//                mealResponse ->
//            if (mealResponse == null){
//                localDataSource.loadFilterIngredient {
//                    onSuccess(
//                        MealResponse(
//                            meals = it.map { mealLocal ->
//                                Meal(
//                                    idMeal = mealLocal.idMeal,
//                                    strMeal = mealLocal.strMeal,
//                                    strArea = mealLocal.strArea,
//                                    strCategory = mealLocal.strCategory,
//                                    strIngredient1 = mealLocal.strIngredient1,
//                                    strIngredient2 = mealLocal.strIngredient2,
//                                    strIngredient3 = mealLocal.strIngredient3,
//                                    strIngredient4 = mealLocal.strIngredient4,
//                                    strIngredient5 = mealLocal.strIngredient5,
//                                    strIngredient6 = mealLocal.strIngredient6,
//                                    strIngredient7 = mealLocal.strIngredient7,
//                                    strIngredient8 = mealLocal.strIngredient8,
//                                    strIngredient9 = mealLocal.strIngredient9,
//                                    strIngredient10 = mealLocal.strIngredient10,
//                                    strIngredient11 = mealLocal.strIngredient11,
//                                    strIngredient12 = mealLocal.strIngredient12,
//                                    strIngredient13 = mealLocal.strIngredient13,
//                                    strIngredient14 = mealLocal.strIngredient14,
//                                    strIngredient15 = mealLocal.strIngredient15,
//                                    strIngredient16 = mealLocal.strIngredient16,
//                                    strIngredient17 = mealLocal.strIngredient17,
//                                    strIngredient18 = mealLocal.strIngredient18,
//                                    strIngredient19 = mealLocal.strIngredient19,
//                                    strIngredient20 = mealLocal.strIngredient20,
//                                    strInstructions = mealLocal.strInstructions,
//                                    strMealThumb = mealLocal.strMealThumb,
//                                    strMeasure1 = mealLocal.strMeasure1,
//                                    strMeasure2 = mealLocal.strMeasure2,
//                                    strMeasure3 = mealLocal.strMeasure3,
//                                    strMeasure4 = mealLocal.strMeasure4,
//                                    strMeasure5 = mealLocal.strMeasure5,
//                                    strMeasure6 = mealLocal.strMeasure6,
//                                    strMeasure7 = mealLocal.strMeasure7,
//                                    strMeasure8 = mealLocal.strMeasure8,
//                                    strMeasure9 = mealLocal.strMeasure9,
//                                    strMeasure10 = mealLocal.strMeasure10,
//                                    strMeasure11 = mealLocal.strMeasure11,
//                                    strMeasure12 = mealLocal.strMeasure12,
//                                    strMeasure13 = mealLocal.strMeasure13,
//                                    strMeasure14 = mealLocal.strMeasure14,
//                                    strMeasure15 = mealLocal.strMeasure15,
//                                    strMeasure16 = mealLocal.strMeasure16,
//                                    strMeasure17 = mealLocal.strMeasure17,
//                                    strMeasure18 = mealLocal.strMeasure18,
//                                    strMeasure19 = mealLocal.strMeasure19,
//                                    strMeasure20 = mealLocal.strMeasure20,
//                                    strTags = mealLocal.strTags,
//                                    strYoutube = mealLocal.strYoutube
//                                )
//                            }
//                        )
//                    )
//                }
//            }else{
//                onSuccess(mealResponse)
//            }
//        }
//    }
//
//    fun loadMealDetail(id:Int,
//                             onSuccess:(MealResponse) -> Unit
//    ){
//        apiDataSource.loadMealDetail(id) {
//                mealResponse ->
//            if (mealResponse == null){
//                localDataSource.loadMealDetail {
//                    onSuccess(
//                        MealResponse(
//                            meals = it.map { mealLocal ->
//                                Meal(
//                                    idMeal = mealLocal.idMeal,
//                                    strMeal = mealLocal.strMeal,
//                                    strArea = mealLocal.strArea,
//                                    strCategory = mealLocal.strCategory,
//                                    strIngredient1 = mealLocal.strIngredient1,
//                                    strIngredient2 = mealLocal.strIngredient2,
//                                    strIngredient3 = mealLocal.strIngredient3,
//                                    strIngredient4 = mealLocal.strIngredient4,
//                                    strIngredient5 = mealLocal.strIngredient5,
//                                    strIngredient6 = mealLocal.strIngredient6,
//                                    strIngredient7 = mealLocal.strIngredient7,
//                                    strIngredient8 = mealLocal.strIngredient8,
//                                    strIngredient9 = mealLocal.strIngredient9,
//                                    strIngredient10 = mealLocal.strIngredient10,
//                                    strIngredient11 = mealLocal.strIngredient11,
//                                    strIngredient12 = mealLocal.strIngredient12,
//                                    strIngredient13 = mealLocal.strIngredient13,
//                                    strIngredient14 = mealLocal.strIngredient14,
//                                    strIngredient15 = mealLocal.strIngredient15,
//                                    strIngredient16 = mealLocal.strIngredient16,
//                                    strIngredient17 = mealLocal.strIngredient17,
//                                    strIngredient18 = mealLocal.strIngredient18,
//                                    strIngredient19 = mealLocal.strIngredient19,
//                                    strIngredient20 = mealLocal.strIngredient20,
//                                    strInstructions = mealLocal.strInstructions,
//                                    strMealThumb = mealLocal.strMealThumb,
//                                    strMeasure1 = mealLocal.strMeasure1,
//                                    strMeasure2 = mealLocal.strMeasure2,
//                                    strMeasure3 = mealLocal.strMeasure3,
//                                    strMeasure4 = mealLocal.strMeasure4,
//                                    strMeasure5 = mealLocal.strMeasure5,
//                                    strMeasure6 = mealLocal.strMeasure6,
//                                    strMeasure7 = mealLocal.strMeasure7,
//                                    strMeasure8 = mealLocal.strMeasure8,
//                                    strMeasure9 = mealLocal.strMeasure9,
//                                    strMeasure10 = mealLocal.strMeasure10,
//                                    strMeasure11 = mealLocal.strMeasure11,
//                                    strMeasure12 = mealLocal.strMeasure12,
//                                    strMeasure13 = mealLocal.strMeasure13,
//                                    strMeasure14 = mealLocal.strMeasure14,
//                                    strMeasure15 = mealLocal.strMeasure15,
//                                    strMeasure16 = mealLocal.strMeasure16,
//                                    strMeasure17 = mealLocal.strMeasure17,
//                                    strMeasure18 = mealLocal.strMeasure18,
//                                    strMeasure19 = mealLocal.strMeasure19,
//                                    strMeasure20 = mealLocal.strMeasure20,
//                                    strTags = mealLocal.strTags,
//                                    strYoutube = mealLocal.strYoutube
//                                )
//                            }
//                        )
//                    )
//                }
//            }else{
//                onSuccess(mealResponse)
//            }
//        }
//    }
//
//    fun loadSearchByName(name:String,
//                       onSuccess:(MealResponse) -> Unit
//    ){
//        apiDataSource.loadSearchByName(name) {
//                mealResponse ->
//            if (mealResponse == null){
//                localDataSource.loadSearchByName {
//                    onSuccess(
//                        MealResponse(
//                            meals = it.map { mealLocal ->
//                                Meal(
//                                    idMeal = mealLocal.idMeal,
//                                    strMeal = mealLocal.strMeal,
//                                    strArea = mealLocal.strArea,
//                                    strCategory = mealLocal.strCategory,
//                                    strIngredient1 = mealLocal.strIngredient1,
//                                    strIngredient2 = mealLocal.strIngredient2,
//                                    strIngredient3 = mealLocal.strIngredient3,
//                                    strIngredient4 = mealLocal.strIngredient4,
//                                    strIngredient5 = mealLocal.strIngredient5,
//                                    strIngredient6 = mealLocal.strIngredient6,
//                                    strIngredient7 = mealLocal.strIngredient7,
//                                    strIngredient8 = mealLocal.strIngredient8,
//                                    strIngredient9 = mealLocal.strIngredient9,
//                                    strIngredient10 = mealLocal.strIngredient10,
//                                    strIngredient11 = mealLocal.strIngredient11,
//                                    strIngredient12 = mealLocal.strIngredient12,
//                                    strIngredient13 = mealLocal.strIngredient13,
//                                    strIngredient14 = mealLocal.strIngredient14,
//                                    strIngredient15 = mealLocal.strIngredient15,
//                                    strIngredient16 = mealLocal.strIngredient16,
//                                    strIngredient17 = mealLocal.strIngredient17,
//                                    strIngredient18 = mealLocal.strIngredient18,
//                                    strIngredient19 = mealLocal.strIngredient19,
//                                    strIngredient20 = mealLocal.strIngredient20,
//                                    strInstructions = mealLocal.strInstructions,
//                                    strMealThumb = mealLocal.strMealThumb,
//                                    strMeasure1 = mealLocal.strMeasure1,
//                                    strMeasure2 = mealLocal.strMeasure2,
//                                    strMeasure3 = mealLocal.strMeasure3,
//                                    strMeasure4 = mealLocal.strMeasure4,
//                                    strMeasure5 = mealLocal.strMeasure5,
//                                    strMeasure6 = mealLocal.strMeasure6,
//                                    strMeasure7 = mealLocal.strMeasure7,
//                                    strMeasure8 = mealLocal.strMeasure8,
//                                    strMeasure9 = mealLocal.strMeasure9,
//                                    strMeasure10 = mealLocal.strMeasure10,
//                                    strMeasure11 = mealLocal.strMeasure11,
//                                    strMeasure12 = mealLocal.strMeasure12,
//                                    strMeasure13 = mealLocal.strMeasure13,
//                                    strMeasure14 = mealLocal.strMeasure14,
//                                    strMeasure15 = mealLocal.strMeasure15,
//                                    strMeasure16 = mealLocal.strMeasure16,
//                                    strMeasure17 = mealLocal.strMeasure17,
//                                    strMeasure18 = mealLocal.strMeasure18,
//                                    strMeasure19 = mealLocal.strMeasure19,
//                                    strMeasure20 = mealLocal.strMeasure20,
//                                    strTags = mealLocal.strTags,
//                                    strYoutube = mealLocal.strYoutube
//                                )
//                            }
//                        )
//                    )
//                }
//            }else{
//                onSuccess(mealResponse)
//            }
//        }
//    }
//
//    fun loadSearchByFirstLetter(name:String,
//                         onSuccess:(MealResponse) -> Unit
//    ){
//        apiDataSource.loadSearchByFirstLetter(name) {
//                mealResponse ->
//            if (mealResponse == null){
//                localDataSource.loadSearchByFirstLetter {
//                    onSuccess(
//                        MealResponse(
//                            meals = it.map { mealLocal ->
//                                Meal(
//                                    idMeal = mealLocal.idMeal,
//                                    strMeal = mealLocal.strMeal,
//                                    strArea = mealLocal.strArea,
//                                    strCategory = mealLocal.strCategory,
//                                    strIngredient1 = mealLocal.strIngredient1,
//                                    strIngredient2 = mealLocal.strIngredient2,
//                                    strIngredient3 = mealLocal.strIngredient3,
//                                    strIngredient4 = mealLocal.strIngredient4,
//                                    strIngredient5 = mealLocal.strIngredient5,
//                                    strIngredient6 = mealLocal.strIngredient6,
//                                    strIngredient7 = mealLocal.strIngredient7,
//                                    strIngredient8 = mealLocal.strIngredient8,
//                                    strIngredient9 = mealLocal.strIngredient9,
//                                    strIngredient10 = mealLocal.strIngredient10,
//                                    strIngredient11 = mealLocal.strIngredient11,
//                                    strIngredient12 = mealLocal.strIngredient12,
//                                    strIngredient13 = mealLocal.strIngredient13,
//                                    strIngredient14 = mealLocal.strIngredient14,
//                                    strIngredient15 = mealLocal.strIngredient15,
//                                    strIngredient16 = mealLocal.strIngredient16,
//                                    strIngredient17 = mealLocal.strIngredient17,
//                                    strIngredient18 = mealLocal.strIngredient18,
//                                    strIngredient19 = mealLocal.strIngredient19,
//                                    strIngredient20 = mealLocal.strIngredient20,
//                                    strInstructions = mealLocal.strInstructions,
//                                    strMealThumb = mealLocal.strMealThumb,
//                                    strMeasure1 = mealLocal.strMeasure1,
//                                    strMeasure2 = mealLocal.strMeasure2,
//                                    strMeasure3 = mealLocal.strMeasure3,
//                                    strMeasure4 = mealLocal.strMeasure4,
//                                    strMeasure5 = mealLocal.strMeasure5,
//                                    strMeasure6 = mealLocal.strMeasure6,
//                                    strMeasure7 = mealLocal.strMeasure7,
//                                    strMeasure8 = mealLocal.strMeasure8,
//                                    strMeasure9 = mealLocal.strMeasure9,
//                                    strMeasure10 = mealLocal.strMeasure10,
//                                    strMeasure11 = mealLocal.strMeasure11,
//                                    strMeasure12 = mealLocal.strMeasure12,
//                                    strMeasure13 = mealLocal.strMeasure13,
//                                    strMeasure14 = mealLocal.strMeasure14,
//                                    strMeasure15 = mealLocal.strMeasure15,
//                                    strMeasure16 = mealLocal.strMeasure16,
//                                    strMeasure17 = mealLocal.strMeasure17,
//                                    strMeasure18 = mealLocal.strMeasure18,
//                                    strMeasure19 = mealLocal.strMeasure19,
//                                    strMeasure20 = mealLocal.strMeasure20,
//                                    strTags = mealLocal.strTags,
//                                    strYoutube = mealLocal.strYoutube
//                                )
//                            }
//                        )
//                    )
//                }
//            }else{
//                onSuccess(mealResponse)
//            }
//        }
//    }


}