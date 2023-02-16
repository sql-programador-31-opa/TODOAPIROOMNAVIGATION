package com.opapruebas.pruebastodoapi.PersonajeRepository

import com.opapruebas.pruebastodoapi.data.Personaje
import com.opapruebas.pruebastodoapi.data.Personajes
import com.opapruebas.pruebastodoapi.data.source.remote.dto.RickAndMortyapi
import com.opapruebas.pruebastodoapi.data.Result
import com.opapruebas.pruebastodoapi.data.source.remote.dto.toListPersonajes
import com.opapruebas.pruebastodoapi.data.source.remote.dto.toPersonaje
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PersonajeRepositoryImpl @Inject constructor(
    private val api:RickAndMortyapi
):PersonajeRepository.PersonajeRepository{
    override fun getPersonajes(page: Int): Flow<Result<List<Personajes>>> = flow {
        emit(Result.Loading())
        try {
            val response = api.getPersonajes(page).toListPersonajes()
            emit(Result.Success(response))
        }catch (e: HttpException){
            emit(Result.Error(
                message = "Algo salio mal",
                data = null
            ))
        }catch (e: IOException){
            emit(Result.Error(
                message = "No se puede conectar al servidor, Revise su conexion",
                data = null
            ))
        }
    }

    override suspend fun getPersonaje(id: Int): Result<Personaje> {
        val response = try {

            api.getPersonaje(id)
        } catch (e:Exception){
            return Result.Error("Error inesperado")
        }
        return  Result.Success(response.toPersonaje())
    }

}