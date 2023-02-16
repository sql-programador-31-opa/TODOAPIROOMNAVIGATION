package com.opapruebas.pruebastodoapi.di

import com.opapruebas.pruebastodoapi.PersonajeRepository.PersonajeRepository
import com.opapruebas.pruebastodoapi.PersonajeRepository.PersonajeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RespositoriesModule {
    @Binds
    abstract fun bindPersonajeRepository(impl: PersonajeRepositoryImpl): PersonajeRepository.PersonajeRepository
}