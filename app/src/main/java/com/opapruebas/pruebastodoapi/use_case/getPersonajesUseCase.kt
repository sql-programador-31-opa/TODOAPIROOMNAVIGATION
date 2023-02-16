package com.opapruebas.pruebastodoapi.use_case

import com.opapruebas.pruebastodoapi.PersonajeRepository.PersonajeRepository
import com.opapruebas.pruebastodoapi.data.Personajes
import com.opapruebas.pruebastodoapi.data.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class getPersonajesUseCase @Inject constructor(
    private val repository: PersonajeRepository.PersonajeRepository
) {
    operator fun invoke(page:Int): Flow<Result<List<Personajes>>> {
        return repository.getPersonajes(page)
    }
}