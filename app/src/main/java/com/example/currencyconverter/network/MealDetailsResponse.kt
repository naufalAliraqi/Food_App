package com.example.currencyconverter.network
import com.example.currencyconverter.data.MealDetails
import com.google.gson.annotations.SerializedName


data class MealDetailsResponse(
    @SerializedName("meals")
    val meals: List<MealDetails?>?
)