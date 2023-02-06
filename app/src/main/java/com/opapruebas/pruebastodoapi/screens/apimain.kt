package com.opapruebas.pruebastodoapi.screens

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun apimain(navController: NavController){
    Scaffold() {
        TopAppBar() {
            Text(text = "TODO APP DE TAREAS")
        }
        Cuerpoapimain(navController)

    }
}

@Composable
fun Cuerpoapimain(navController: NavController) {
    TODO("Not yet implemented")
}
