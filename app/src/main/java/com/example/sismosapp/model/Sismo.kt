package com.example.sismosapp.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Sismo(
    @PrimaryKey
    var horaLocal: String = "",
    @SerializedName("horaUtc")
    var horaUtc: String = "",
    @SerializedName("latitud")
    var latitud: String = "",
    @SerializedName("longitud")
    var longitud: String = "",
    @SerializedName("magnitud")
    var magnitud: String = "",
    @SerializedName("mapa")
    var mapa: String = "",
    @SerializedName("profundidad")
    var profundidad: String = "",
    @SerializedName("referencia")
    var referencia: String = ""
)