package com.example.currencyconverter.ui.fragments

import android.util.Log
import com.example.currencyconverter.data.Category
import com.example.currencyconverter.databinding.FragmentHomeBinding
import com.example.currencyconverter.network.CategoryResponse
import com.example.currencyconverter.network.State
import com.example.currencyconverter.repositories.CategoryRepository
import com.example.currencyconverter.ui.base.BaseFragment
import com.example.currencyconverter.util.CategoryAdapter
import com.example.currencyconverter.util.hide
import com.example.currencyconverter.util.show
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val categoryRepository = CategoryRepository()
    private lateinit var adapter: CategoryAdapter

    override fun bindingInflater(): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater)

    override fun setUp() {
        requestWeatherData()
    }

    private fun requestWeatherData() {
        categoryRepository.getParsingInfo(CategoryResponse::class.java)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { state ->
                    showResponseState(state)
                },
                {
                    Log.v("SSD_2", "Error, Fail on observer")
                }
            )
    }

    private fun <T> showResponseState(responseState: State<T>) = when (responseState) {
        is State.Fail -> showFailState()
        is State.Loading -> Log.v("SSD_2", "Now is Loading")
        is State.Success -> showSuccessState(responseData = (responseState.data) as CategoryResponse)
    }

    private fun showSuccessState(responseData: CategoryResponse) {
        Log.v("SSD_2", "on Sec")
        binding.apply {
            screenOnSuccess.show()
            screenOnFail.hide()
        }

        bindWeatherData(responseData)
    }

    private fun bindWeatherData(responseData: CategoryResponse) {
        adapter = CategoryAdapter(responseData.categories)
        Log.v("SSD_2", (responseData.categories).toString())
        binding.recyclerCategory.adapter = adapter
    }

    private fun showFailState() {
        Log.v("SSD_2", "on Fail")
        binding.apply {
            screenOnSuccess.hide()
            screenOnFail.show()
        }
    }
}