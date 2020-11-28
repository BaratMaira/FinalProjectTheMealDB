package com.example.mealdb.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mealdb.dataSource.ApiDataSource
import com.example.mealdb.model.Area
import com.example.mealdb.model.Category
import com.example.mealdb.model.Ingredient
import com.example.mealdb.model.Meal
import com.example.mealdb.repository.MealRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ViewModel (
    private val apiDataSource: ApiDataSource
): ViewModel(), CoroutineScope{
    private val job = Job()
    override val coroutineContext: CoroutineContext
    get() = Dispatchers.Main + job

    override fun onCleared() {
        super.onCleared()

        job.cancel()
    }
    private val mealsMutableLiveData = MutableLiveData<List<Meal>>()
    internal val mealsLiveData: LiveData<List<Meal>> = mealsMutableLiveData
    private val categoryMutableLiveData = MutableLiveData<List<Category>>()
    internal val categoryLiveData: LiveData<List<Category>> = categoryMutableLiveData
    private val filterCategoryMutableLiveData = MutableLiveData<List<Meal>>()
    internal val filterCategoryLiveData: LiveData<List<Meal>> = filterCategoryMutableLiveData
    private val areaMutableLiveData = MutableLiveData<List<Area>>()
    internal val areaLiveData: LiveData<List<Area>> = areaMutableLiveData
    private val filterAreaMutableLiveData = MutableLiveData<List<Meal>>()
    internal val filterAreaLiveData: LiveData<List<Meal>> = filterAreaMutableLiveData
    private val ingredientMutableLiveData = MutableLiveData<List<Ingredient>>()
    internal val ingredientLiveData: LiveData<List<Ingredient>> = ingredientMutableLiveData
    private val filterIngredientMutableLiveData = MutableLiveData<List<Meal>>()
    internal val filterIngredientLiveData: LiveData<List<Meal>> = filterIngredientMutableLiveData
    private val mealDetailMutableLiveData = MutableLiveData<List<Meal>>()
    internal val mealDetailLiveData: LiveData<List<Meal>> = mealDetailMutableLiveData
    private val searchByNameMutableLiveData = MutableLiveData<List<Meal>>()
    internal val searchByNameLiveData: LiveData<List<Meal>> = searchByNameMutableLiveData
    private val searchByFirstLetterMutableLiveData = MutableLiveData<List<Meal>>()
    internal val searchByFirstLetterLiveData: LiveData<List<Meal>> = searchByFirstLetterMutableLiveData

    fun loadRandomMeal(){
        launch {
            val response = apiDataSource.loadRandomMeal()
            if (response != null){
                mealsMutableLiveData.value = response.meals
            }
        }
    }

    fun loadCategory(){
        launch{
            val response = apiDataSource.loadCategory()
            if (response != null){
                categoryMutableLiveData.value = response.categories

            }
        }
    }

    fun loadFilterCategory(name: String){
        launch{
            val response = apiDataSource.loadFilterCategory(name)
            if (response != null){
                filterCategoryMutableLiveData.value = response.meals
            }
        }
    }

    fun loadArea(name:String) {
        launch {
            val response = apiDataSource.loadArea(name)
            if (response != null) {
                areaMutableLiveData.value = response.meals
            }
        }
    }

    fun loadFilterArea(name:String){
        launch{
            val response =apiDataSource.loadFilterArea(name)
            if (response != null) {
                filterAreaMutableLiveData.value = response.meals
            }
        }
    }

    fun loadIngredient(name:String){
        launch{
            val response  = apiDataSource.loadIngredient(name)
            if(response != null){
            ingredientMutableLiveData.value = response.meals
            }
        }

    }

    fun loadFilterIngredient(name:String){
        launch{
            val response  = apiDataSource.loadFilterIngredient(name)
            if(response != null){
                filterIngredientMutableLiveData.value = response.meals
            }
        }
    }

    fun loadMealDetail(id: Int){
        launch{
            val response  = apiDataSource.loadMealDetail(id)
            if(response != null){
                mealDetailMutableLiveData.value = response.meals
            }
        }
    }

    fun loadSearchByName(name:String){
        launch{
            val response  = apiDataSource.loadSearchByName(name)
            if(response != null){
                searchByNameMutableLiveData.value = response.meals
            }
        }
    }

    fun loadSearchByFirstLetter(name: String){
        launch{
            val response  = apiDataSource.loadSearchByFirstLetter(name)
            if(response != null){
                searchByFirstLetterMutableLiveData.value = response.meals
            }
        }
    }
}

class Factory(
    private val apiDataSource: ApiDataSource
) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModel(apiDataSource) as T
    }
}