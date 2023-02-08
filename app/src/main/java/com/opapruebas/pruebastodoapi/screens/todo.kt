package com.opapruebas.pruebastodoapi.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import com.opapruebas.pruebastodoapi.data.BDMaster
import com.opapruebas.pruebastodoapi.data.Tarea
import com.opapruebas.pruebastodoapi.img
import com.opapruebas.pruebastodoapi.navigation.AppScreens
import com.opapruebas.pruebastodoapi.viewmodel.TareaViewModel
import com.opapruebas.pruebastodoapi.viewmodel.TareaViewModelAbstract
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@Composable
fun todo(navController: NavController,homeViewModel:TareaViewModelAbstract) {
todobar(navController,homeViewModel)
}


@Composable
fun todobar(navController: NavController,homeViewModel:TareaViewModelAbstract){

    Scaffold( topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="Boton de atras",
                modifier = Modifier.clickable { navController.popBackStack() })
            Text(text = "TODO APP DE TAREAS")
        }
    }) {
    Box(modifier = Modifier
        .fillMaxSize()){
        content(homeViewModel)
        FloatingActionButton(modifier = Modifier
            .padding(all = 20.dp)
            .align(alignment = Alignment.BottomEnd) , onClick = {
            navController.navigate(route = AppScreens.addtodo.route) }, )
        {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Crear nota")
        }
    }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun content(homeViewModel:TareaViewModelAbstract){
    val TareasListState = homeViewModel.ListaTareasFlow.collectAsState(initial = listOf())
    LazyColumn{
        items(TareasListState.value.size){
            index ->
            val tareas = TareasListState.value[index]
                tareatextos(titulo = tareas.Titulo , progreso = tareas.Progreso , descripcion = tareas.Descripcion )
        }
    }
}

@Composable
fun tareatextos(titulo:String,progreso:Int,descripcion:String){
    var expandir by remember {mutableStateOf(false)}
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
    ){
        Row(modifier = Modifier
            .clickable {
                expandir = !expandir
                }
            .padding(5.dp)) {
            Column(modifier = Modifier
                .weight(0.3f)) {
                Box(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                    img(progreso)
                }
            }
            Column(modifier = Modifier
                .weight(0.7f)
                .padding(start = 10.dp)
            ) {
                Row() {
                    Text(text = titulo, modifier = Modifier.weight(0.5f), color = MaterialTheme.colors.primary )

                    Text(text = "$progreso%", modifier = Modifier.weight(0.2f).clickable { }.padding(end = 3.dp), color = MaterialTheme.colors.primary)
                }
                Spacer(modifier = Modifier.height(15.dp))
                Row() {
                    texto(TextoString = descripcion, if (expandir) Int.MAX_VALUE else 1)
                }


            }
        }
        Icon(imageVector = Icons.Default.Delete, contentDescription ="Boton de atras",
            modifier = Modifier
                .clickable { }
                .clip(CircleShape)
                .background(MaterialTheme.colors.primary)
                .align(alignment = Alignment.TopEnd))
    }
}

@Composable
fun texto(TextoString:String, Lineas:Int = Int.MAX_VALUE){
    Text(TextoString, maxLines = Lineas , color = MaterialTheme.colors.primary)
}
@Composable
@Preview
fun precompo (){
    var expandir by remember {mutableStateOf(false)}
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ){
            Row(modifier = Modifier.background(MaterialTheme.colors.onBackground)) {
                Column(modifier = Modifier
                    .weight(0.3f)) {
                    Box(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                        img(progress = 20)
                    }
                }
                Column(modifier = Modifier
                    .weight(0.7f)
                    .padding(start = 10.dp)
                ) {
                Row() {
                     Text(text = "titulo", modifier = Modifier.weight(0.8f), color = MaterialTheme.colors.primary )

                    Text(text = "%", modifier = Modifier.weight(0.2f).clickable { }, color = MaterialTheme.colors.primary)
                }
                    Spacer(modifier = Modifier.height(15.dp))
                Row() {
                        texto(TextoString = "Descripcion ", if (expandir) Int.MAX_VALUE else 1)
                    }


                }
            }
            Icon(imageVector = Icons.Default.Delete, contentDescription ="Boton de atras",
                modifier = Modifier
                    .clickable { }
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.primary)
                    .align(alignment = Alignment.TopEnd))
        }
    
}



