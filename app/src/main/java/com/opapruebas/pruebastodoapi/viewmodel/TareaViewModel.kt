package com.opapruebas.pruebastodoapi.viewmodel

import androidx.lifecycle.ViewModel
import com.opapruebas.pruebastodoapi.TareaRepository.TareaRepository
import com.opapruebas.pruebastodoapi.data.Tarea
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

interface TareaViewModelAbstract {

    val ListaTareasFlow: Flow<List<Tarea>>
    fun addTarea(tarea: Tarea)
    fun updateTarea(id:Int,Titulo:String,Progreso:Boolean)
    fun deleteTarea(id: Int)
}
@HiltViewModel
class TareaViewModel
@Inject constructor(
    private val TareaRepository:TareaRepository
):ViewModel(),TareaViewModelAbstract{

    private val ioScope = CoroutineScope(Dispatchers.IO)

    override val ListaTareasFlow: Flow<List<Tarea>> = TareaRepository.getTareas()


    override fun addTarea(tarea: Tarea) {
        ioScope.launch {
            TareaRepository.addTarea(tarea = tarea)
        }
    }
    override fun updateTarea(id:Int,Titulo:String,Progreso:Boolean) {
        ioScope.launch {
            TareaRepository.updateTarea(id,Titulo,Progreso)
        }
    }

    override fun deleteTarea(id: Int) {
        ioScope.launch {
            TareaRepository.deleteTarea(id)
        }
    }

}