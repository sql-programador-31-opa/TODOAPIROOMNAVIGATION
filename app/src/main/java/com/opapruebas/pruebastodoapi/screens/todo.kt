package com.opapruebas.pruebastodoapi.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.opapruebas.pruebastodoapi.addimg
import com.opapruebas.pruebastodoapi.data.Tarea
import com.opapruebas.pruebastodoapi.deleteimg
import com.opapruebas.pruebastodoapi.img
import com.opapruebas.pruebastodoapi.viewmodel.TareaViewModelAbstract

@Composable
fun todo(navController: NavController,homeViewModel:TareaViewModelAbstract) {
todobar(navController,homeViewModel)
}


@Composable
fun todobar(navController: NavController,homeViewModel:TareaViewModelAbstract){

    Scaffold( topBar = {
        TopAppBar() {
            Box(Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.padding(top = 15.dp)) {
                    Column(modifier = Modifier.weight(0.1f)) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription ="Boton de atras",
                            modifier = Modifier.clickable { navController.popBackStack() })


                    }
                    Column(modifier = Modifier.weight(0.8f)) {
                        Text(text = "TODO APP DE TAREAS",fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    Column(modifier = Modifier.weight(0.1f)) {
                        addimg(navController)
                    }



                }
             
                
              

            }

        }
    }) {
    Box(modifier = Modifier
        .fillMaxSize()){
        content(homeViewModel)


    }
    }
}
enum class Popstate{
    Open,Close
}

@Composable
fun content(homeViewModel:TareaViewModelAbstract){
    val popstate = rememberSaveable { mutableStateOf(Popstate.Close)}
    var tarea:MutableState<Int> = rememberSaveable { mutableStateOf(0)}
    var tareatitulo:MutableState<String> = rememberSaveable { mutableStateOf("")}
    var tareadescripcion:MutableState<String> = rememberSaveable { mutableStateOf("")}
    var tareaprogreso:MutableState<Int> = rememberSaveable { mutableStateOf(0)}
    val TareasListState = homeViewModel.ListaTareasFlow.collectAsState(initial = listOf())
    LazyColumn{
        items(TareasListState.value.size){
            index ->
            val tareas = TareasListState.value[index]

            Row(modifier = Modifier.clickable{
               popstate.value = Popstate.Open
                tarea.value = tareas.id
                tareatitulo.value = tareas.Titulo
                tareadescripcion.value = tareas.Descripcion
                tareaprogreso.value = tareas.Progreso
            }) {
                tareatextos(titulo = tareas.Titulo , progreso = tareas.Progreso , descripcion = tareas.Descripcion, id = tareas.id ,homeViewModel )
            }
        }
    }
    when(popstate.value){
        Popstate.Open -> {
            Dialogoedit (
                tareatitulo = tareatitulo,
                tareadescripcion = tareadescripcion,
                dimiss = {popstate.value = Popstate.Close },
                save = {titulo,descripcion->
                    homeViewModel.updateTarea(tarea.value,titulo,descripcion,tareaprogreso.value)
                }
            )
        }
        Popstate.Close -> {

        }
    }

}
enum class Popprogress{
    Open,Close
}

@Composable
fun tareatextos(titulo:String,progreso:Int,descripcion:String,id:Int,homeViewModel:TareaViewModelAbstract){
    var expandir by remember {mutableStateOf(false)}
    val popprogress = rememberSaveable { mutableStateOf(Popprogress.Close)}

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
    ){
        Row(modifier = Modifier
            .padding(8.dp)) {
            Column(modifier = Modifier
                .weight(0.2f)) {
                Box(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
                    img(progreso)
                }
            }
            Column(modifier = Modifier
                .weight(0.8f)
                .padding(start = 10.dp)
                .clickable {
                    expandir = !expandir
                }
            ) {
                Row() {
                    Text(text = titulo, fontSize = 20.sp,fontWeight = FontWeight.SemiBold, color = MaterialTheme.colors.primary,
                        modifier = Modifier.weight(0.7f))

                    Text(text = "$progreso%",fontSize = 20.sp, fontWeight = FontWeight.SemiBold, modifier = Modifier
                        .weight(0.3f)
                        .clickable {
                            popprogress.value = Popprogress.Open
                        }
                        .padding(end = 3.dp), color = MaterialTheme.colors.primary)
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                ) {
                    texto(TextoString = descripcion, if (expandir) Int.MAX_VALUE else 1)
                }


            }
        }
        Column(modifier = Modifier.align(alignment = Alignment.TopEnd).clickable{
            homeViewModel.deleteTarea(id)
        }) {
            deleteimg()
        }


    }

    when(popprogress.value){
        Popprogress.Open -> {
            progressdialog (
                tareatitulo= titulo,
                tareaprogress = progreso.toFloat(),
                dimiss = {popprogress.value = Popprogress.Close },
                save = {
                    homeViewModel.updateTarea(id = id , Titulo =  titulo, Descripcion = descripcion, Progreso = it)
                }
            )
        }
        Popprogress.Close -> {

        }
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
            Row(modifier =
            Modifier
                .background(MaterialTheme.colors.onBackground)
                .clip(RoundedCornerShape(25.dp))) {
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

                    Text(text = "%", modifier = Modifier
                        .weight(0.2f)
                        .clickable { }, color = MaterialTheme.colors.primary)
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



