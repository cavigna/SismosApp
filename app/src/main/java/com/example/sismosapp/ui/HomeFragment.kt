package com.example.sismosapp.ui

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sismosapp.R
import com.example.sismosapp.application.SismoApplication
import com.example.sismosapp.databinding.FragmentHomeBinding
import com.example.sismosapp.listadapters.SismoListAdapter
import com.example.sismosapp.model.Sismo
import com.example.sismosapp.viewmodel.SismoModelFactory
import com.example.sismosapp.viewmodel.SismoViewModel


class HomeFragment : Fragment(), SismoListAdapter.ExtractorDeItem{

    private lateinit var binding: FragmentHomeBinding

    private lateinit var application : Application

    private val viewModel by activityViewModels<SismoViewModel> {
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
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val recyclerView = binding.recycler
        val adapter = SismoListAdapter(this)
        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.listadoSismosDB.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })


        return binding.root
    }

    override fun alHacerClick(sismo: Sismo) {
        viewModel.indicarSismoElegido(sismo)

        var sismoVM = viewModel.sismoElegido.value

        Log.i("prueba", sismoVM.toString())

        //findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)
    }


}