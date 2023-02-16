package com.opapruebas.pruebastodoapi.PersonajeRepository

import com.opapruebas.pruebastodoapi.data.Personaje
import com.opapruebas.pruebastodoapi.data.Personajes
import com.opapruebas.pruebastodoapi.data.Result
import kotlinx.coroutines.flow.Flow

interface PersonajeRepository {
    interface PersonajeRepository {

        fun getPersonajes(page:Int): Flow<Result<List<Personajes>>>

        suspend fun getPersonaje(id:Int):Result<Personaje>
    }
}