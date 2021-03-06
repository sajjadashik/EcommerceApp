package com.sajjad.ecommerceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.sajjad.ecommerceapp.databinding.FragmentLoginBinding
import com.sajjad.ecommerceapp.viewmodels.LoginViewModel


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        loginViewModel.authLD.observe(viewLifecycleOwner){
            if (it == LoginViewModel.Authentication.AUTHENTICATED){
                findNavController().popBackStack()
            }
        }
        loginViewModel.errMsgLD.observe(viewLifecycleOwner){
            binding.errMsgTV.text = it
        }

        binding.loginBtn.setOnClickListener {
            val email = binding.emailET.text.toString()
            val pass = binding.passwordET.text.toString()
            if(email.isEmpty()){
                binding.errMsgTV.text = "Email Address Cannot be empty"
                return@setOnClickListener
            }
            if(pass.isEmpty()){
                binding.errMsgTV.text = "Password Cannot be empty"
                return@setOnClickListener
            }
            loginViewModel.loginAdmin(email,pass)
        }
        return binding.root
    }

}