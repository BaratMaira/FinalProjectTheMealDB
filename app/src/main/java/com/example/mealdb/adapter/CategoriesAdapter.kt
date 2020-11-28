package com.example.mealdb.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdb.R
import com.example.mealdb.model.Category
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.category_list.view.*

class CategoriesAdapter(
    private var categories: ArrayList<Category>,
    private val onMealClick: (Category) -> Unit)
    : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CategoriesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R
                        .layout.category_list, parent, false)
        )

    override fun getItemCount() = categories.size


    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    inner class CategoriesViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(category: Category){
            with(view){
                meal_category.text = category.strCategory
                Picasso.get().load(category.strCategoryThumb).into(view.meal_image)

                setOnClickListener{
                    onMealClick(category)
                }
            }
        }
    }
}