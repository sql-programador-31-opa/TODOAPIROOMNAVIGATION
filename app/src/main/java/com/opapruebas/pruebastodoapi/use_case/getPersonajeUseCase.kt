package com.opapruebas.pruebastodoapi.use_case

import com.opapruebas.pruebastodoapi.PersonajeRepository.PersonajeRepository
import com.opapruebas.pruebastodoapi.data.Personaje
import javax.inject.Inject
import com.opapruebas.pruebastodoapi.data.Result

class getPersonajeUseCase @Inject constructor(
    private val repository: PersonajeRepository.PersonajeRepository
){
    suspend operator fun invoke(id:Int): Result<Personaje>{
        return repository.getPersonaje(id)
    }
}