package com.example.mealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdb.R
import com.example.mealdb.model.Meal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.search_list.view.*

class SearchByLetterAdapter(
    private var meals: ArrayList<Meal>
)
    : RecyclerView.Adapter<SearchByLetterAdapter.SearchViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SearchViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R
                        .layout.search_by_letter, parent, false)
        )

    override fun getItemCount() = meals.size


    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    inner class SearchViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(meal: Meal){
            with(view){
                meal_title.text = meal.strMeal
                meal_category.text = meal.strCategory
                Picasso.get().load(meal.strMealThumb).into(view.meal_image)
            }
        }
    }
}