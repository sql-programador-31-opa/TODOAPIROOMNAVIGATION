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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.opapruebas.pruebastodoapi.data.Tarea
import com.opapruebas.pruebastodoapi.viewmodel.TareaViewModelAbstract

@Composable
fun addtodo(navController: NavController,homeViewModel: TareaViewModelAbstract){
    Scaffold() {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="Boton de atras",
                modifier = Modifier.clickable { navController.popBackStack() })
            Text(text = "Agregar Tarea")
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
      var descripcion by remember { mutableStateOf("")}
      var selection by remember { mutableStateOf(10f) }

        OutlinedTextField(
            value = titulo, onValueChange = {
                titulo=it
            },
            label = { Text(text = "Titulo")},
            maxLines = 1
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = descripcion, onValueChange = {
                descripcion=it
            },
            label = { Text(text = "Descripcion")},
        )
        Spacer(modifier = Modifier.height(15.dp))
        Column(
        ) {
            texto(TextoString = "Progreso de la tarea")
        Spacer(modifier = Modifier.height(15.dp) )


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(contentAlignment = Alignment.Center) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Slider(
                            value = selection,
                            valueRange =  0f..100f,
                            onValueChange = { selection = it },
                            modifier = Modifier
                                .padding(end = 20.dp)
                                .weight(0.9f)
                        )
                        val progress = selection.toInt().toString()
                        Text(text = "$progress%",maxLines = 1 ,
                            modifier = Modifier
                                .weight(0.1f)
                        )
                    }
                }

            }
        }
       val tarea = Tarea(Titulo = titulo, Descripcion = descripcion, Progreso = selection.toInt())
        botondefaul(navController,homeViewModel,tarea)
    }
}

@Composable
fun botondefaul(navController: NavController,homeViewModel: TareaViewModelAbstract,tarea: Tarea){
    Button(onClick = {
        navController.popBackStack()
        homeViewModel.addTarea(tarea) }, modifier = Modifier
        .clip(RoundedCornerShape(50))) {
    texto(TextoString = "Agregar Tarea")
    }
}

