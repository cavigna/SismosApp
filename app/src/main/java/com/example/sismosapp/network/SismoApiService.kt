package com.example.sismosapp.network

import com.example.sismosapp.model.SismoList
import retrofit2.http.GET

interface SismoApiService {
    @GET(".")
    suspend fun buscarSismosRemoto(): SismoList
}