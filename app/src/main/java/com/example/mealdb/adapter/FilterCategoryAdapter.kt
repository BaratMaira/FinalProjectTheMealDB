package com.example.mealdb.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdb.R
import com.example.mealdb.model.Meal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.filter_categorylist.*
import kotlinx.android.synthetic.main.filter_categorylist.view.*

class FilterCategoryAdapter(
    private var meals: ArrayList<Meal>,
    private val onMealClick: (Meal) -> Unit)
    : RecyclerView.Adapter<FilterCategoryAdapter.FilterCategoriesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FilterCategoriesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R
                        .layout.filter_categorylist, parent, false)
        )

    override fun getItemCount() = meals.size


    override fun onBindViewHolder(holder: FilterCategoriesViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    inner class FilterCategoriesViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(category: Meal){
            with(view){
                meal_title.text = category.strMeal
                Picasso.get().load(category.strMealThumb).into(view.meal_image)

                setOnClickListener{
                    onMealClick(category)
                }

                love.setOnClickListener{
                    love.setColorFilter(Color.RED);
                    Toast.makeText(context, "Added to favourites", Toast.LENGTH_SHORT);
                }
            }
        }
    }
}