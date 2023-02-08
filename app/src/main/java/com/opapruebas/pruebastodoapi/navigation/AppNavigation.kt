package com.opapruebas.pruebastodoapi.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.opapruebas.pruebastodoapi.screens.addtodo
import com.opapruebas.pruebastodoapi.screens.apimain
import com.opapruebas.pruebastodoapi.screens.inicio
import com.opapruebas.pruebastodoapi.screens.todo
import com.opapruebas.pruebastodoapi.viewmodel.TareaViewModelAbstract


@SuppressLint("SuspiciousIndentation")
@Composable
fun AppNavigation(homeViewModel: TareaViewModelAbstract){
    val navigationController = rememberNavController()
        NavHost(navController = navigationController, startDestination = AppScreens.inicio.route){
        composable(route = AppScreens.inicio.route){
            inicio(navigationController)
        }
        composable(route = AppScreens.apimain.route){
            apimain(navigationController)
            }
        composable(route = AppScreens.todo.route){
                todo(navigationController,homeViewModel)
            }
        composable(route = AppScreens.addtodo.route){
                addtodo(navigationController,homeViewModel)
            }

        }
}