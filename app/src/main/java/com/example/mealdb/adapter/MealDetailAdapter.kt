package com.example.mealdb.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdb.R
import com.example.mealdb.model.Meal
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_meal_detail.view.*
import kotlinx.android.synthetic.main.meal_detail_list.view.*

class MealDetailAdapter(
    private var meals: ArrayList<Meal>)
    : RecyclerView.Adapter<MealDetailAdapter.MealDetailViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MealDetailViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R
                        .layout.meal_detail_list, parent, false)
        )
    override fun getItemCount() = meals.size


    override fun onBindViewHolder(holder: MealDetailViewHolder, position: Int) {
        holder.bind(meals[position])
    }

    inner class MealDetailViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun bind(meal: Meal){
            with(view){
                meal_name.text = meal.strMeal
                category_detail.text = meal.strCategory
                Picasso.get().load(meal.strMealThumb).into(view.male_image_detail)
                area_detail.text = meal.strArea
                instructions.text = meal.strInstructions
                i1.text = meal.strIngredient1
                i2.text = meal.strIngredient2
                i3.text = meal.strIngredient3
                i4.text = meal.strIngredient4
                i5.text = meal.strIngredient5
                i6.text = meal.strIngredient6
                i7.text = meal.strIngredient7
                i8.text = meal.strIngredient8
                i9.text = meal.strIngredient9
                i10.text = meal.strIngredient10

                youtube.setOnClickListener {
                     val intent = Intent(Intent.ACTION_VIEW)
                    intent.setData(Uri.parse(meal.strYoutube))
                    view.context.startActivity(intent)
                }
            }
        }
    }
}