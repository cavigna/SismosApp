package com.example.sismosapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sismosapp.model.Sismo
import kotlinx.coroutines.flow.Flow

@Dao
interface SismoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregarSismo(sismo: Sismo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregarListadoSismo(listadiSismo: List<Sismo>)

    @Query("SELECT * FROM sismo")
    fun listadoSismos(): Flow<List<Sismo>>
}