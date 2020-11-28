package com.example.mealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdb.R
import com.example.mealdb.model.Meal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.filter_categorylist.view.*

class FilterIngredientAdapter(
    private var meals: ArrayList<Meal>,
    private val onMealClick: (Meal) -> Unit)
    : RecyclerView.Adapter<FilterIngredientAdapter.FilterIngredientsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FilterIngredientsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R
                        .layout.filter_ingredients_list, parent, false)
        )

    override fun getItemCount() = meals.size


    override fun onBindViewHolder(holder: FilterIngredientsViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    inner class FilterIngredientsViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(category: Meal){
            with(view){
                meal_title.text = category.strMeal
                Picasso.get().load(category.strMealThumb).into(view.meal_image)

                setOnClickListener{
                    onMealClick(category)
                }
            }
        }
    }
}