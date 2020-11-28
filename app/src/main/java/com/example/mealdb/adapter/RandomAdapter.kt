package com.example.mealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdb.R
import com.example.mealdb.model.Meal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.latest_list.view.*

class RandomAdapter(
    private var meals: ArrayList<Meal>,
    private val onMealClick: (Meal) -> Unit)
    : RecyclerView.Adapter<RandomAdapter.RandomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RandomViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R
                        .layout.latest_list, parent, false)
        )

    override fun getItemCount() = meals.size


    override fun onBindViewHolder(holder: RandomViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    inner class RandomViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(meal: Meal){
            with(view){
                meal_title.text = meal.strMeal
                meal_category.text = meal.strCategory
                Picasso.get().load(meal.strMealThumb).into(view.meal_image)

                setOnClickListener{
                    onMealClick(meal)
                }
            }
        }
    }
}