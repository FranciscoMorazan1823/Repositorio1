package com.naldana.ventas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.determinacion.R
import com.example.determinacion.databinding.FragmentFacturaBinding


/**
 * A simple [Fragment] subclass.
 */
class facturaFragment : Fragment() {

    private lateinit var viewModel: facturaviewModel


    private  lateinit var binding: facturaFragmentFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentFacturaBinding>(
            inflater, R.layout.fragment_factura, container, false
        )
        return binding.root

        viewModel = ViewModelProvider(this).get(facturaviewModel::class.java)


        fun update(){


            binding.Nombre.text=viewModel.nombre
            binding.Codigo.text=viewModel.codigo
            binding.Cantidad.text=viewModel.cantidad
            binding.Precio=viewModel.precio
            binding.Proveedor=viewModel.proveedor
            binding.Fecha= viewModel.fecha


        }

        binding.Facturar.setOnClickListener{update()}




    }




}
