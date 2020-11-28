package com.example.mealdb.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mealdb.model.AreaLocal

@Dao
interface AreaDao{

    @Insert
    fun insertArea(areaLocal: AreaLocal)

    @Query("SELECT *FROM area")
    fun getAreaList(): List<AreaLocal>

}