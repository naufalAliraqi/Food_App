package com.example.currencyconverter.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.currencyconverter.R

abstract class BaseFragment<VB: ViewBinding>: Fragment() {
    private lateinit var _binding: VB
    abstract fun bindingInflater(): VB
    protected val binding get() = _binding

    abstract fun setUp()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater()
        setUp()

        return _binding.root
    }

    private fun changeNavigation(to: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.root_fragment, to)
        transaction.addToBackStack(null).commit()
    }

    protected fun navigationTo(to: Fragment) {
        changeNavigation(to)
    }

    protected fun backNavigation(to: Fragment) {
        changeNavigation(to)
    }

}