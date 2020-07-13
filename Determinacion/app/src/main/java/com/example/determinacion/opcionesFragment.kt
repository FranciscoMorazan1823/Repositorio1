package com.frank.mipymes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.determinacion.R
import com.example.determinacion.databinding.FragmentOpcionesBinding

/**
 * A simple [Fragment] subclass.
 */
class opcionesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentOpcionesBinding>(
            inflater, R.layout.fragment_opciones, container, false
        )
        return binding.root
    }

}
