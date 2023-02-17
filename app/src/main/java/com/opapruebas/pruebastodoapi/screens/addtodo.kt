package com.opapruebas.pruebastodoapi.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.opapruebas.pruebastodoapi.data.Tarea
import com.opapruebas.pruebastodoapi.viewmodel.TareaViewModelAbstract

@Composable
fun addtodo(navController: NavController,homeViewModel: TareaViewModelAbstract){
    Scaffold() {
        TopAppBar(modifier = Modifier.fillMaxHeight(0.3f)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Nueva Tarea",fontSize = 50.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(alignment = Alignment.Center), color = Color.White)
            }
        }
        CuerpoaddTodo(navController,homeViewModel)

    }
}

@Composable
fun CuerpoaddTodo(navController: NavController,homeViewModel: TareaViewModelAbstract) {

    Column(modifier = Modifier
        .padding(30.dp)
        .clip(CircleShape)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

      var titulo by remember { mutableStateOf("")}


        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = titulo, onValueChange = {
                titulo=it
            },
            label = { Text(text = "Titulo",color = MaterialTheme.colors.primary,fontSize = 30.sp)},
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(15.dp))
        Spacer(modifier = Modifier.height(15.dp))
       val tarea = Tarea(Titulo = titulo,  Progreso = false)
        botondefaul(navController,homeViewModel,tarea)
    }
}

@Composable
fun botondefaul(navController: NavController,homeViewModel: TareaViewModelAbstract,tarea: Tarea){
    Button(onClick = {
        navController.popBackStack()
        homeViewModel.addTarea(tarea) }, modifier = Modifier
        .clip(RoundedCornerShape(25))) {
    Text(text = "Agregar Tarea",fontSize = 25.sp)
    }
}

