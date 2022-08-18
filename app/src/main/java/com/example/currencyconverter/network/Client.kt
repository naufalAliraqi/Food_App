package com.example.currencyconverter.network

import android.util.Log
import com.google.gson.Gson
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class Client {
    private val okHttpClient = OkHttpClient()
    private val httpUrlBuilder = HttpUrlBuilder()
    private val gson = Gson()
    private lateinit var response: Response

    fun <T> requestData(requestClass: T): State<CategoryResponse> {
        val request = buildRequest(httpUrlBuilder.categoriesUrlBuilder())
        response = makeRequest(request)
        return checkResponseState(response, requestClass)
    }

    private fun buildRequest(httpUrl: HttpUrl) = Request.Builder().url(httpUrl).build()

    private fun makeRequest(request: Request): Response {
        return okHttpClient.newCall(request).execute()
    }

    private fun <T> checkResponseState(response: Response, requestClass: T) = if (response.isSuccessful) {
        val categoryResponse = gson.fromJson(response.body!!.string(), CategoryResponse::class.java)
        State.Success(categoryResponse)
    } else {
        State.Fail(response.message)
    }
}