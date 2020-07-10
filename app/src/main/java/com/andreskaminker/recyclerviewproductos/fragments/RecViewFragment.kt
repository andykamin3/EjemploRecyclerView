package com.andreskaminker.recyclerviewproductos.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.andreskaminker.recyclerviewproductos.dtypes.Product
import com.andreskaminker.recyclerviewproductos.adapters.ProductAdapter
import com.andreskaminker.recyclerviewproductos.databinding.FragmentRecViewBinding
import com.andreskaminker.recyclerviewproductos.helpers.clickBindingProduct


class RecViewFragment : Fragment(), clickBindingProduct {
    private  var _binding: FragmentRecViewBinding? = null
    lateinit var v: View
    private val TAG = "RecViewFragment"
    private val productList = mutableListOf<Product>(
        Product(
            price = 12.00f,
            name = "Banana",
            quantity = 12,
            imageURL = "https://api.time.com/wp-content/uploads/2019/11/gettyimages-459761948.jpg?quality=85&crop=0px%2C74px%2C1024px%2C536px&resize=1200%2C628&strip"
        ),
        Product(
            price = 15.00f,
            name = "Manzana",
            quantity = 10,
            imageURL = "https://static2.abc.es/media/201206/21/apple--644x362.jpeg"
        ),
        Product(
            price = 16.00f,
            name = "Pera",
            quantity = 8,
            imageURL = "https://ecomercioagrario.com/wp-content/uploads/2019/07/pera-624x321.jpg"

        )
    )
    private val binding get()= _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecViewBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        val view = binding.root
        return view
    }


    override fun onStart() {
        super.onStart()
        val mManager : LinearLayoutManager = LinearLayoutManager(context)
        val productAdapter = ProductAdapter(productList, this){product -> onClickProduct(product = product)}
        binding.recView.apply {
            adapter = productAdapter
            layoutManager = mManager
            setHasFixedSize(true)
        }
    }

    override fun onClickProduct(product: Product) {
        val directions = RecViewFragmentDirections.actionRecViewFragmentToProductViewFragment(product)
        binding.root.findNavController().navigate(directions)

    }


}