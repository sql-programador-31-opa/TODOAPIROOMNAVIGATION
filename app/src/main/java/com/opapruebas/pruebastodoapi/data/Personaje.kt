package com.opapruebas.pruebastodoapi.data

import com.opapruebas.pruebastodoapi.data.source.remote.dto.Location
import com.opapruebas.pruebastodoapi.data.source.remote.dto.Origin

data class Personaje(
    val id:Int,
    val name:String,
    val status:String,
    val specie:String,
    val gender:String,
    val origin: Origin,
    val location: Location,
    val img:String
)