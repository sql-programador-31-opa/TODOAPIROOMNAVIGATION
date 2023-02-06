package com.opapruebas.pruebastodoapi.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun addtodo(navController: NavController){
    Scaffold() {
        TopAppBar() {
            Text(text = "TODO APP DE TAREAS")
        }
        CuerpoaddTodo(navController)

    }
}

@Composable
fun CuerpoaddTodo(navController: NavController) {
    TODO("Not yet implemented")
}
