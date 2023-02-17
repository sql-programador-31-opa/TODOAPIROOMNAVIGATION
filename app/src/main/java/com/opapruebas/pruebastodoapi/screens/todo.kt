package com.opapruebas.pruebastodoapi.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.opapruebas.pruebastodoapi.addimg
import com.opapruebas.pruebastodoapi.data.Tarea
import com.opapruebas.pruebastodoapi.deleteimg
import com.opapruebas.pruebastodoapi.editimg
import com.opapruebas.pruebastodoapi.img
import com.opapruebas.pruebastodoapi.navigation.AppScreens
import com.opapruebas.pruebastodoapi.viewmodel.TareaViewModelAbstract

@Composable
fun todo(navController: NavController,homeViewModel:TareaViewModelAbstract) {
todobar(navController,homeViewModel)
}


@Composable
fun todobar(navController: NavController,homeViewModel:TareaViewModelAbstract){

    Scaffold( topBar = {
        TopAppBar(modifier = Modifier.fillMaxHeight(0.2f)) {
            Box(Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.padding(top = 15.dp)) {
                    Column(modifier = Modifier.weight(0.8f)) {
                        Box(modifier = Modifier.fillMaxWidth()) {
                            Text(text = "TO_DO",fontSize = 50.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(alignment = Alignment.Center), color = Color.White)
                        }
                    }

                }
            }
        }
    },
        floatingActionButton = {
            FloatingActionButton(onClick = {navController.navigate(route = AppScreens.addtodo.route) }, backgroundColor = MaterialTheme.colors.primary) {
                Text(text = "+", fontSize = 40.sp, color = Color.White)
                
            }
        }

    ) {
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
    var tarea:MutableState<Int> = rememberSaveable { mutableStateOf(0)}
    val TareasListState = homeViewModel.ListaTareasFlow.collectAsState(initial = listOf())
    LazyColumn(modifier = Modifier.padding(15.dp)){
        items(TareasListState.value.size){
            index ->
            val tareas = TareasListState.value[index]
                Card(elevation = 20.dp, shape = RoundedCornerShape(20.dp), modifier = Modifier.padding(horizontal = 50.dp)) {
                    tareatextos(titulo = tareas.Titulo , progreso = tareas.Progreso , id = tareas.id ,homeViewModel )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}


enum class Popprogress{
    Open,Close
}
enum class Popstatedelete{
    Open,Close
}


@Composable
fun tareatextos(titulo:String,progreso:Boolean,id:Int,homeViewModel:TareaViewModelAbstract){
    val popprogress = rememberSaveable { mutableStateOf(Popprogress.Close)}
    val popdelete = rememberSaveable { mutableStateOf(Popstatedelete.Close)}
    val checkprogres:MutableState<Boolean> = remember { mutableStateOf(progreso)}
    val popstate = rememberSaveable { mutableStateOf(Popstate.Close)}
    var tareatitulo:MutableState<String> = rememberSaveable { mutableStateOf(titulo)}
    var tareaprogreso:MutableState<Boolean> = rememberSaveable { mutableStateOf(progreso)}


                Row(modifier=Modifier.padding(10.dp)) {
                    Column(modifier = Modifier.weight(0.2f)) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            Column(modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .fillMaxSize()) {
                                Checkbox(checked = progreso,
                                    onCheckedChange ={
                                        checkprogres.value = it
                                        popprogress.value = Popprogress.Open
                                    },
                                    colors = CheckboxDefaults.colors(
                                        checkedColor = MaterialTheme.colors.onSecondary))
                            }

                        }

                    }
                    Column(modifier = Modifier.weight(0.6f)) {
                        Box() {
                            Text(text = titulo, fontSize = 55.sp,fontWeight = FontWeight.SemiBold, color = MaterialTheme.colors.primary, modifier = Modifier.align(alignment = Alignment.Center))
                        }
                    }
                    Column(modifier = Modifier
                        .weight(0.1f)
                        .clickable {
                            popdelete.value = Popstatedelete.Open
                        }) {
                        deleteimg()
                    }
                    Spacer(modifier = Modifier.height(10.dp).border(border = BorderStroke(1.dp,MaterialTheme.colors.primary)))
                    Column(modifier = Modifier
                        .weight(0.1f)
                        .clickable {
                            popstate.value = Popstate.Open
                        }) {
                        editimg()
                    }

                }

    when(popstate.value){
        Popstate.Open -> {
            Dialogoedit (
                tareatitulo = tareatitulo,
                dimiss = {popstate.value = Popstate.Close },
                save = {titulo->
                    homeViewModel.updateTarea(id,titulo,tareaprogreso.value)
                }
            )
        }
        Popstate.Close -> {

        }
    }

    when(popdelete.value){
        Popstatedelete.Open -> {
            deletedialog (
                tareatitulo= titulo,
                dimiss = {popdelete.value = Popstatedelete.Close },
                delete = {
                    homeViewModel.deleteTarea(id)
                }
            )
        }
        Popstatedelete.Close -> {

        }
    }

    when(popprogress.value){
        Popprogress.Open -> {
            progressdialog (
                tareatitulo= titulo,
                dimiss = {popprogress.value = Popprogress.Close
                    checkprogres.value = !checkprogres.value},
                save = {
                    homeViewModel.updateTarea(id = id , Titulo =  titulo, Progreso = !checkprogres.value)


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
                        img(progress = false)
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
                    .align(alignment = Alignment.TopEnd)
                    .padding(end = 10.dp))
        }

}



