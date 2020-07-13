package com.frank.mipymes

import android.graphics.Path
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import android.view.*
import com.example.determinacion.R
import com.example.determinacion.databinding.FragmentInicioBinding


/**
 * A simple [Fragment] subclass.
 */
class inicioFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    val binding = DataBindingUtil.inflate<FragmentInicioBinding>(
            inflater, R.layout.fragment_inicio, container, false
        )

        binding.Perfil.setOnClickListener { view: View ->
            view.findNavController().
            navigate(R.id.action_fragment_inicio_to_fragment_inventario)

        }

        binding.Ventas.setOnClickListener { view: View ->
            view.findNavController().
            navigate(R.id.action_fragment_inicio_to_fragment_ventas)

        }


        binding.Inventario.setOnClickListener { view: View ->
            view.findNavController().
            navigate(R.id.action_fragment_inicio_to_fragment_inventario)

        }

        binding.Opciones.setOnClickListener { view: View ->
            view.findNavController().
            navigate(R.id.action_fragment_inicio_to_fragment_opciones)

        }

        return binding.root
    }


}
