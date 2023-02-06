package com.opapruebas.pruebastodoapi.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Tareas_table")
data class Tarea(
            @ColumnInfo(name = "Titulo") var Titulo:String,
            @ColumnInfo(name = "Descripcion") var Descripcion:String,
            @ColumnInfo(name = "Progreso") var Progreso:Int
){
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}
