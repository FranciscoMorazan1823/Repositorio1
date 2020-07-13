package com.naldana.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.R
import androidx.navigation.findNavController
import com.example.android.guesstheword.sereen.loginViewModel




/**
 * A simple [Fragment] subclass.
 */
class loginFragment : Fragment() {

    private lateinit var viewModel: loginViewModel


    private  lateinit var binding: loginFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false
        )
        binding.login.setOnClickListener { view: View ->
            view.findNavController().
            navigate(R.id.action_fragment_login_to_fragment_inicio)

        }
        return binding.root
        viewModel = ViewModelProvider(this).get(loginViewModel::class.java)


        fun update(){


            binding.email.text=viewModel.email
            binding.pass.text= viewModel.password



        }

        binding.login.onClickListener{update() }

}
