package com.opapruebas.pruebastodoapi.di

import com.opapruebas.pruebastodoapi.data.source.remote.dto.RickAndMortyapi
import com.opapruebas.pruebastodoapi.ui.Util.BASEURL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideRickAndMortyApi(): RickAndMortyapi {
        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyapi::class.java)
    }
}