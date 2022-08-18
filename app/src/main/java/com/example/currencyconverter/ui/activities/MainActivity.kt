package com.example.currencyconverter.ui.activities

import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.ActivityMainBinding
import com.example.currencyconverter.network.CategoryResponse
import com.example.currencyconverter.network.State
import com.example.currencyconverter.repositories.CategoryRepository
import com.example.currencyconverter.ui.base.BaseActivity
import com.example.currencyconverter.ui.fragments.HomeFragment
import com.example.currencyconverter.util.Constant
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun bindingInflater() = ActivityMainBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTheme(R.style.Theme_CurrencyConverter)
        setDefaultMainFragment()
    }

    private fun setDefaultMainFragment() {
        val homeFragment = HomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.root_fragment, homeFragment)
        transaction.commit()
    }

}