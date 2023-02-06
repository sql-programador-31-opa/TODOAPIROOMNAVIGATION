package com.opapruebas.pruebastodoapi.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.opapruebas.pruebastodoapi.navigation.AppScreens


@Composable
fun inicio(navController: NavController){
        Scaffold() {
                TopAppBar() {
                    Text(text = "TODO API APP")
                }
            CuerpoInicio(navController)
        }
}

@Composable
fun CuerpoInicio(navController: NavController){
    Column(
        modifier =Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Button(onClick = {
                navController.navigate(route = AppScreens.todo.route)
            }) {
                Text(text = "TODO APP")
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(onClick = {
                    navController.navigate(route = AppScreens.apimain.route)
                }) {
                    Text(text = "API APP")
        }

        }

    }
}
