package com.opapruebas.pruebastodoapi.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
entities = [Tarea::class],
version = 1
)
abstract class BDMaster:RoomDatabase(){

    abstract fun daoTarea(): daoTarea

     companion object {
        private var INSTANCE: BDMaster? = null
        fun getInstance(context: Context): BDMaster {
            if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context,BDMaster::class.java,"Tarea_BD")
                .fallbackToDestructiveMigration()
                .build()
            }
            return  INSTANCE as BDMaster
        }


     }
}