package com.opapruebas.pruebastodoapi.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import com.opapruebas.pruebastodoapi.data.BDMaster
import com.opapruebas.pruebastodoapi.data.Tarea
import com.opapruebas.pruebastodoapi.img
import kotlinx.coroutines.launch


lateinit var Tarea: Tarea

lateinit var room : BDMaster




@Composable
fun todo(navController: NavController) {
todobar(navController)
}

@Composable
fun todobar(navController: NavController){

    Scaffold( topBar = {
        TopAppBar() {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="Boton de atras",
                modifier = Modifier.clickable { navController.popBackStack() })
            Text(text = "TODO APP DE TAREAS")
        }
    }) {
    Box(modifier = Modifier
        .fillMaxSize()){
        CuerpoTodo(navController)
    }
    }


}

@Composable
fun CuerpoTodo(navController: NavController) {
    Row( modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .background(MaterialTheme.colors.background)
    ){
        img()
        tareatextos()
    }

}

@Composable
fun tareatextos(){
    var expandir by remember {
    mutableStateOf(false)
    }
        Column(
            modifier = Modifier
                .padding(start = 10.dp)
                .padding(top = 10.dp)
                .clickable { expandir = !expandir }
        ) {

            texto(
                TextoString = "Titulo de la tarea del todo",
                Lineas = 1
            )
            Spacer(modifier = Modifier.height(16.dp))


            Row(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.width(50.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally ){
                    Icon(imageVector = Icons.Default.Refresh , contentDescription ="Progressicon" )
                    texto(
                        TextoString = "Progreso%",
                        Lineas = 1
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
               Button(onClick = { /*TODO*/ },modifier = Modifier
                   .height(35.dp)
                   .width(100.dp)
                   ) {
                   Text(text = "progreso")
               }

           }


            Spacer(modifier = Modifier.height(16.dp))
            texto(
                TextoString = "Cuerpo o descripcion de la tarea",
                if (expandir) Int.MAX_VALUE else 1
            )
        }
}

@Composable
fun texto(TextoString:String, Lineas:Int = Int.MAX_VALUE){
    Text(TextoString, maxLines = Lineas )
}


@Preview(showSystemUi = true)
@Composable
fun ptodo(){

        Row( modifier = Modifier
            .padding(10.dp)
            .background(MaterialTheme.colors.background)
        ){
            img()
            tareatextos()
        }


}
