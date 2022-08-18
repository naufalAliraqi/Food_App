package com.example.currencyconverter.network

import com.example.currencyconverter.util.Constant
import okhttp3.HttpUrl

class HttpUrlBuilder {

    private fun baseURLBuilder() = with(Constant) {
        HttpUrl.Builder().scheme(SCHEME)
            .host(HOST)
    }

    fun categoriesUrlBuilder() = with(Constant) {
        baseURLBuilder()
            .addPathSegment(Categories_PATH_SEGMENT)
            .build()
    }

    fun mealsUrlBuilder() = with(Constant) {
        baseURLBuilder()
            .addPathSegment(Categories_PATH_SEGMENT)
            .build()
    }

    fun mealDetailsUrlBuilder() = with(Constant) {
        baseURLBuilder()
            .addPathSegment(Categories_PATH_SEGMENT)
            .build()
    }
}