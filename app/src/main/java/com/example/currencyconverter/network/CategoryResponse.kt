package com.example.currencyconverter.network
import com.example.currencyconverter.data.Category
import com.google.gson.annotations.SerializedName


data class CategoryResponse(
    @SerializedName("categories")
    val categories: List<Category>
)