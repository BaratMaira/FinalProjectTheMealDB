package com.example.mealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdb.R
import com.example.mealdb.model.Ingredient
import kotlinx.android.synthetic.main.ingredient_list.view.*

class IngredientAdapter(
    private var meals: ArrayList<Ingredient>,
    private val onMealClick: (Ingredient) -> Unit)
    : RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        IngredientViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.ingredient_list, parent, false)
        )

    override fun getItemCount() = meals.size


    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    inner class IngredientViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(meals: Ingredient){
            with(view){
                meal_ingedient.text = meals.strIngredient
                setOnClickListener{
                    onMealClick(meals)
                }
            }
        }
    }
}