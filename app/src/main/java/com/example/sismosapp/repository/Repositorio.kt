package com.example.sismosapp.repository

import com.example.sismosapp.db.SismoDAO
import com.example.sismosapp.model.Sismo
import com.example.sismosapp.network.SismoApiService

class Repositorio(private val api: SismoApiService, private val dao: SismoDAO) {

    suspend fun buscarSismosRemoto() = api.buscarSismosRemoto()

    suspend fun agregarSismo(sismo: Sismo) = dao.agregarSismo(sismo)
    suspend fun agregarListadoSismo(listadoSismo: List<Sismo>) = dao.agregarListadoSismo(listadoSismo)


    fun listadoSismos() = dao.listadoSismos()
}