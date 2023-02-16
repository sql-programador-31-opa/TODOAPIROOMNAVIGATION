package com.opapruebas.pruebastodoapi.data.source.remote.dto

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyapi {
    @GET("character/")
    suspend fun getPersonajes(
        @Query("page") page:Int
    ):PersonajesDTO

    @GET("character/{id")
    suspend fun getPersonaje(
        @Path("id") id:Int
    ): PersonajeDTO
}