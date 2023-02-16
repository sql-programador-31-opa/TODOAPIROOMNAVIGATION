package com.opapruebas.pruebastodoapi.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.opapruebas.pruebastodoapi.screens.addtodo
import com.opapruebas.pruebastodoapi.screens.apimain
import com.opapruebas.pruebastodoapi.screens.inicio
import com.opapruebas.pruebastodoapi.screens.todo
import com.opapruebas.pruebastodoapi.viewmodel.RickAndMortyViewModel
import com.opapruebas.pruebastodoapi.viewmodel.TareaViewModelAbstract


@SuppressLint("SuspiciousIndentation")
@Composable
fun AppNavigation(homeViewModel: TareaViewModelAbstract,viewModel: RickAndMortyViewModel = hiltViewModel()){
    val navigationController = rememberNavController()
        NavHost(navController = navigationController, startDestination = AppScreens.inicio.route){
        composable(route = AppScreens.inicio.route){
            inicio(navigationController)
        }
            composable(route = AppScreens.apimain.route){
                apimain(navigationController,viewModel)
            }

        composable(route = AppScreens.todo.route){
                todo(navigationController,homeViewModel)
            }
        composable(route = AppScreens.addtodo.route){
                addtodo(navigationController,homeViewModel)
            }

        }
}