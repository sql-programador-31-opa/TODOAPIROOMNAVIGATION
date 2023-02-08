package com.opapruebas.pruebastodoapi.TareaRepository

import com.opapruebas.pruebastodoapi.data.Tarea
import com.opapruebas.pruebastodoapi.data.daoTarea
import kotlinx.coroutines.flow.Flow

class TareaRepository (
    private val daotarea: daoTarea
){
    fun getTareas(): Flow<List<Tarea>> = daotarea.getTareas()
    suspend fun addTarea(tarea: Tarea) = daotarea.addTarea(Tarea = tarea)
    suspend fun updateTarea(tarea: Tarea) = daotarea.updateTarea(id = tarea.id,tarea.Titulo,tarea.Descripcion,tarea.Progreso)
    suspend fun deleteTarea(tarea: Tarea) = daotarea.deleteTarea(id = tarea.id)

}