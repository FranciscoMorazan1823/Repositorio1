package com.frank.mipymes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.determinacion.R
import com.example.determinacion.databinding.FragmentPerfilBinding


/**
 * A simple [Fragment] subclass.
 */
class perfilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentPerfilBinding>(
            inflater, R.layout.fragment_perfil, container, false
        )
        return binding.root
    }

}
