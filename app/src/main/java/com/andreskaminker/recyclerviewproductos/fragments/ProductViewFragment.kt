package com.andreskaminker.recyclerviewproductos.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andreskaminker.recyclerviewproductos.R
import com.andreskaminker.recyclerviewproductos.databinding.FragmentProductViewBinding
import com.andreskaminker.recyclerviewproductos.fragments.ProductViewFragmentArgs.fromBundle
import com.bumptech.glide.Glide


class ProductViewFragment : Fragment() {

    private var _binding : FragmentProductViewBinding? = null
    private val binding: FragmentProductViewBinding get() = _binding!!
    private val TAG = "ProductViewFragment"
    val recordedProduct by lazy {
        fromBundle(requireArguments()).mProduct
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProductViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$recordedProduct")
        binding.apply {
            priceTextView.text = getString(R.string.precio, recordedProduct.price)
            quantityTextView.text = getString(R.string.cantidad, recordedProduct.quantity)
            titleTextView.text = recordedProduct.name
            Glide.with(requireActivity()).load(recordedProduct.imageURL).into(productImageView)
        }
    }




}