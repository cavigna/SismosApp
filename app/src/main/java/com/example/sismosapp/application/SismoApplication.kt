package com.example.sismosapp.application

import android.app.Application
import com.example.sismosapp.db.BaseDeDatos
import com.example.sismosapp.network.SismoApiService
import com.example.sismosapp.repository.Repositorio
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SismoApplication: Application() {

    private val retrofitClient by lazy {
        Retrofit.Builder()
            .baseUrl("https://api-sismologia-chile.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SismoApiService::class.java)
    }

    private val db : BaseDeDatos by lazy { BaseDeDatos.getDataBase(this) }

    val repo by lazy { Repositorio(retrofitClient, db.dao()) }



}