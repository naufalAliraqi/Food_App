package com.example.currencyconverter.network
import com.example.currencyconverter.data.Meal
import com.google.gson.annotations.SerializedName


data class MealResponse(
    @SerializedName("meals")
    val meals: List<Meal?>?
)