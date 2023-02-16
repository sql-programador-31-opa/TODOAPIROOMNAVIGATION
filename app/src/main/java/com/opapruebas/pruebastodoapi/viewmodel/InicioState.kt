package com.opapruebas.pruebastodoapi.viewmodel

import com.opapruebas.pruebastodoapi.data.Personajes

data class InicioState(
    val personajes : List<Personajes> = emptyList(),
    val showPrevious: Boolean = false,
    val showNext:Boolean = false,
    val isLoading:Boolean = false
)
