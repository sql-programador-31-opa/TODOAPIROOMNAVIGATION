package com.opapruebas.pruebastodoapi.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            Text(text = "Bienvenido",
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.primary,
            fontSize = 50.sp|)
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Button(onClick = {
                navController.navigate(route = AppScreens.todo.route)
            }) {
                Text(text = "TODO APP")
            }
            Spacer(modifier = Modifier.width(30.dp))
          

        }

    }
}
