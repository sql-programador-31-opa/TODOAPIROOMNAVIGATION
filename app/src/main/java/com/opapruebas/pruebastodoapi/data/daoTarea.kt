package com.opapruebas.pruebastodoapi.data


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface daoTarea {
@Query("SELECT * FROM Tareas_table")
fun getTareas(): Flow<List<Tarea>>

@Insert
suspend fun addTarea(Tarea:Tarea)

@Query("UPDATE Tareas_table SET Titulo =:Titulo, Descripcion =:Descripcion, Progreso =:Progreso WHERE id =:id")
suspend fun updateTarea(id:Int, Titulo:String, Descripcion:String, Progreso:Int)

@Query("DELETE FROM Tareas_table WHERE id =:id")
suspend fun deleteTarea(id:Int)
}