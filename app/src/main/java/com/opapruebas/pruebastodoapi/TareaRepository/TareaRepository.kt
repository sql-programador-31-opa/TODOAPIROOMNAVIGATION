package com.opapruebas.pruebastodoapi.TareaRepository

import com.opapruebas.pruebastodoapi.data.Tarea
import com.opapruebas.pruebastodoapi.data.daoTarea
import kotlinx.coroutines.flow.Flow

class TareaRepository (
    private val daotarea: daoTarea
){
    fun getTareas(): Flow<List<Tarea>> = daotarea.getTareas()
    suspend fun addTarea(tarea: Tarea) = daotarea.addTarea(Tarea = tarea)
    suspend fun updateTarea(id:Int,Titulo:String,Descripcion:String,Progreso:Int) = daotarea.updateTarea(id = id,Titulo=Titulo,Descripcion=Descripcion,Progreso=Progreso)
    suspend fun deleteTarea(id:Int) = daotarea.deleteTarea(id = id)

}