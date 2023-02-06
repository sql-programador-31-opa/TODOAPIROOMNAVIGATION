package com.opapruebas.pruebastodoapi.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
entities = [Tarea::class],
version = 1
)
abstract class BDMaster:RoomDatabase(){
abstract fun daoTarea():daoTarea
}