package com.example.currencyconverter.data

import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("idMeal")
    val mealId: String?,
    @SerializedName("strMeal")
    val mealName: String?,
    @SerializedName("strMealThumb")
    val mealImageURL: String?
)