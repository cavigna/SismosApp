package com.example.sismosapp.viewmodel

import androidx.lifecycle.*
import com.example.sismosapp.model.Sismo
import com.example.sismosapp.repository.Repositorio
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class SismoViewModel(private val repositorio: Repositorio) : ViewModel() {

    var listadoSismosDB: LiveData<List<Sismo>> = repositorio.listadoSismos().asLiveData()

    var sismoElegido = MutableLiveData<Sismo>()

    //private var _listadoSismosDB:MutableLiveData<List<Sismo>> = MutableLiveData<List<Sismo>>()

    // val listadoSismosDB : LiveData<List<Sismo>> = _listadoSismosDB


    init {
        agregarSismosDb()
    }

    fun agregarSismosDb() {
        viewModelScope.launch(IO) {
            repositorio.agregarListadoSismo(repositorio.buscarSismosRemoto())
        }
    }

    fun indicarSismoElegido(sismo: Sismo){
        viewModelScope.launch {
            sismoElegido.postValue(sismo)

        }
    }

//    fun buscarListadoDB(){
//        viewModelScope.launch(IO){
//            val respuestaApi = repositorio.listadoSismos().asLiveData()
//            _listadoSismosDB.postValue(respuestaApi)
//        }
//    }
}