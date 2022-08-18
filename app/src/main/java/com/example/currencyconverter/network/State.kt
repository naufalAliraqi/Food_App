package com.example.currencyconverter.network

sealed class State<out T> {
    object Loading : State<Nothing>()
    data class Fail(val message: String) : State<Nothing>()
    data class Success<T>(val data: T) : State<T>()
}