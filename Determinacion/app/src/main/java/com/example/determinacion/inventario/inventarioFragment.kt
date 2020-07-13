package com.naldana.inventario
import android.util.Log

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.R


import androidx.lifecycle.ViewModelProvider



import inventarioViewModel


/**
 * A simple [Fragment] subclass.
 */
class inventarioFragment<FragmentInventarioBinding> : Fragment() {

private lateinit var viewModel: inventarioViewModel


    private  lateinit var binding: inventarioFragment<Any?>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentInventarioBinding>(
            inflater, R.layout.fragment_inventario, container, false
        )



        return binding.root
        Log.i("inventarioFragment", "Called viewModelProvider")

        viewModel = ViewModelProvider(this).get(inventarioViewModel::class.java)


        fun update(){


            binding.nameProduct.text=viewModel.name.toString()
            binding.Code.String=viewModel.code
            binding.precioventa=viewModel.precioVenta
            binding.preciocompra=viewModel.precioCompra
            binding.Stock= viewModel.stock


        }

        binding.Add.setOnClickListener{update()}


    }

}

