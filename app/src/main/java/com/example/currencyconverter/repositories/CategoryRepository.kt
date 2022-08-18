package com.example.currencyconverter.repositories

import android.util.Log
import com.example.currencyconverter.network.CategoryResponse
import com.example.currencyconverter.network.Client
import com.example.currencyconverter.network.State
import io.reactivex.rxjava3.core.Observable
import okhttp3.HttpUrl

class CategoryRepository {

    private val client = Client()

    fun <T> getParsingInfo(requestClass: T): Observable<State<CategoryResponse>> = Observable.create { emitter ->
        emitter.onNext(State.Loading)
        emitter.onNext(client.requestData(requestClass))
        emitter.onComplete()
    }

}