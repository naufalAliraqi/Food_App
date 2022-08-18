package com.example.currencyconverter.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.currencyconverter.R
import com.example.currencyconverter.data.Category
import com.example.currencyconverter.databinding.ItemCategoryBinding

class CategoryAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = categories.size - 1

    class CategoryViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemCategoryBinding.bind(viewItem)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        bindCategory(holder, position)
    }

    private fun bindCategory(holder: CategoryViewHolder, position: Int) {
        val currentCategory = categories[position]
        holder.binding.apply {
            textCategoryName.text = currentCategory.categoryName
            textCategoryDetails.text = currentCategory.categoryDescription
            Glide.with(this.root.context).load(currentCategory.categoryImageURL).into(imageCategory)
        }
    }
}