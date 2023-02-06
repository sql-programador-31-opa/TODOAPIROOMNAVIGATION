package com.opapruebas.pruebastodoapi.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface daoTarea {
@Query("SELECT * FROM Tareas_table")
suspend fun getTareas(): LiveData<List<Tarea>>

@Query("SELECT * FROM Tareas_table WHERE id =:id")
suspend fun gettarea(id:Int):Tarea?

@Insert
suspend fun addTarea(Tarea:Tarea)

@Query("UPDATE Tareas_table SET Titulo =:Titulo, Descripcion =:Descripcion, Progreso =:Progreso WHERE id =:id")
suspend fun updateTarea(id:Int, Titulo:String, Descripcion:String, Progreso:Int)

@Query("DELETE FROM Tareas_table WHERE id =:id")
suspend fun deleteTarea(id:Int)
}