package com.example.sismosapp.ui

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import coil.load
import com.example.sismosapp.R
import com.example.sismosapp.application.SismoApplication
import com.example.sismosapp.databinding.FragmentDetailsBinding
import com.example.sismosapp.model.Sismo
import com.example.sismosapp.viewmodel.SismoModelFactory
import com.example.sismosapp.viewmodel.SismoViewModel


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var application: Application

    private val viewModel by viewModels<SismoViewModel> {
        SismoModelFactory((application as SismoApplication).repo)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        application = requireActivity().application

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)

        val sismo = viewModel.sismoElegido.value!!
        with(binding){

            //viewModel.indicarSismoElegido(si)




            imageView2.load(sismo.mapa)
            textView3.text = sismo.referencia
        }





        return binding.root
    }


}