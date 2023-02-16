package com.opapruebas.pruebastodoapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.opapruebas.pruebastodoapi.data.Result
import com.opapruebas.pruebastodoapi.use_case.getPersonajesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn



@HiltViewModel
class RickAndMortyViewModel
@Inject constructor(
    private val getPersonajesUseCase: getPersonajesUseCase
): ViewModel(){

    var state by mutableStateOf(InicioState(isLoading = true))
        private set

    private val _eventFlow = MutableSharedFlow<uiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var pagina = 1
    init {
        getPersonajes(increase = false )
    }

    fun getPersonajes(increase:Boolean){
        viewModelScope.launch {
            if (increase) pagina ++ else if(pagina > 1) pagina--
            val showPrevious = pagina > 1
            val showNext = pagina < 42
            getPersonajesUseCase(pagina).onEach {
                    result ->
                when(result){
                    is Result.Success->{
                        state = state.copy(
                            personajes = result.data ?: emptyList(),
                            isLoading = false,
                            showPrevious = showPrevious,
                            showNext = showNext
                        )
                    }
                    is Result.Error->{
                        state = state.copy(
                            isLoading = false
                        )
                        _eventFlow.emit(uiEvent.ShowSnackBar(
                            result.message ?: "Error Desconocido "
                        ))
                    }
                    is Result.Loading->{
                        state = state.copy(
                            isLoading = true
                        )
                    }
                }

            }.launchIn(this)
        }
    }


    sealed class uiEvent{
        data class ShowSnackBar(val message:String):uiEvent()
    }

}