package com.example.mealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdb.R
import com.example.mealdb.model.Meal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.filter_categorylist.view.*

class FilterAreaAdapter(
    private var meals: ArrayList<Meal>,
    private val onMealClick: (Meal) -> Unit)
    : RecyclerView.Adapter<FilterAreaAdapter.FilterAreaViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FilterAreaViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R
                        .layout.filter_area_list, parent, false)
        )

    override fun getItemCount() = meals.size


    override fun onBindViewHolder(holder: FilterAreaViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    inner class FilterAreaViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(area: Meal){
            with(view){
                meal_title.text = area.strMeal
                Picasso.get().load(area.strMealThumb).into(view.meal_image)

                setOnClickListener{
                    onMealClick(area)
                }
            }
        }
    }
}