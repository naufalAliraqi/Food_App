package com.example.currencyconverter.data

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory")
    val categoryId: String?,
    @SerializedName("strCategory")
    val categoryName: String?,
    @SerializedName("strCategoryDescription")
    val categoryDescription: String?,
    @SerializedName("strCategoryThumb")
    val categoryImageURL: String?
)