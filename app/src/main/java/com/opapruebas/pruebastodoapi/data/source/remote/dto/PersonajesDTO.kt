package com.opapruebas.pruebastodoapi.data.source.remote.dto

import com.opapruebas.pruebastodoapi.data.Personajes

data class PersonajesDTO(
    val info: Info,
    val results: List<Resultado>
)

fun PersonajesDTO.toListPersonajes():List<Personajes>{
    val resultEntries = results.mapIndexed { _, entries ->
        Personajes(
            id = entries.id,
            name = entries.name,
            specie = entries.species,
            status = entries.status,
            img = entries.image

        )
    }
    return resultEntries
}
