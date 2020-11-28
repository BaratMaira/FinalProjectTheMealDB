package com.example.mealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdb.R
import com.example.mealdb.model.Area
import kotlinx.android.synthetic.main.area_list.view.*

class AreaAdapter(
    private var meals: ArrayList<Area>,
    private val onMealClick: (Area) -> Unit)
    : RecyclerView.Adapter<AreaAdapter.AreaViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AreaViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R
                        .layout.area_list, parent, false)
        )

    override fun getItemCount() = meals.size


    override fun onBindViewHolder(holder: AreaViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    inner class AreaViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(meals: Area){
            with(view){
                meal_area.text = meals.strArea
                setOnClickListener{
                    onMealClick(meals)
                }
            }
        }
    }
}