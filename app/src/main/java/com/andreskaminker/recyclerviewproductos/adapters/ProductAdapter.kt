package com.andreskaminker.recyclerviewproductos.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andreskaminker.recyclerviewproductos.dtypes.Product
import com.andreskaminker.recyclerviewproductos.adapters.ProductAdapter.ProductHolder
import com.andreskaminker.recyclerviewproductos.databinding.HolderProductBinding
import com.andreskaminker.recyclerviewproductos.fragments.RecViewFragment
import com.bumptech.glide.Glide

class ProductAdapter(private val productList: MutableList<Product>, private val ctx: RecViewFragment, val onItemClicker : (Product) -> Unit) : RecyclerView.Adapter<ProductHolder>(){
    private lateinit var binding: HolderProductBinding
    private val TAG = "Product Adapter"
    class ProductHolder(val cardBinding: HolderProductBinding): RecyclerView.ViewHolder(cardBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        binding = HolderProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHolder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.cardBinding.apply {
            Glide.with(ctx.requireActivity()).load(productList[position].imageURL).into(this.imageView)
            textViewName.text = productList[position].name

            productView.setOnClickListener {
                onItemClicker(productList[position])
            }
        }
    }
}