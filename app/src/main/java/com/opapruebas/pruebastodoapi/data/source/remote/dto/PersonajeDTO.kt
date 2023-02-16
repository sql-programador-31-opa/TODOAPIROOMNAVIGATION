package com.opapruebas.pruebastodoapi.data.source.remote.dto

import com.opapruebas.pruebastodoapi.data.Personaje

data class PersonajeDTO(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)


fun PersonajeDTO.toPersonaje(): Personaje {
    return Personaje(
        id=id,
        name=name,
        status=status,
        specie = species,
        origin = origin,
        location = location,
        img = image,
        gender = gender
    )
}