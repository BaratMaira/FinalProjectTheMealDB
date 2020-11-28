package com.example.mealdb.networking

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {
    private const val ENDPOINT = "https://www.themealdb.com/api/json/v1/1/"

    fun getRetrofit() =
        Retrofit.Builder().baseUrl(ENDPOINT).addConverterFactory(GsonConverterFactory.create()).build()

    fun getApiClient() =
        getRetrofit().create(ApiClient::class.java)

}