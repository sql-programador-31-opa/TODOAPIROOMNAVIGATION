package com.opapruebas.pruebastodoapi.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.opapruebas.pruebastodoapi.data.Tarea
import com.opapruebas.pruebastodoapi.viewmodel.TareaViewModelAbstract


@Composable
fun Dialogoedit(
tareatitulo:MutableState<String>,
tareadescripcion:MutableState<String>,
dimiss:()->Unit,
save:(String,String)->Unit
){
    val titulo = rememberSaveable { mutableStateOf(tareatitulo.value)}
    var descripcion = rememberSaveable { mutableStateOf(tareadescripcion.value)}
    Dialog(onDismissRequest = {dimiss()}){
        Column(modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(10.dp)
            ) {
            OutlinedTextField(
                value = titulo.value,
                onValueChange = { tituloe ->
                    titulo.value = tituloe
                },
                label = { Text(text = "Titulo")},
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(15.dp))
            OutlinedTextField(
                value = descripcion.value, onValueChange = {
                    descripcion.value=it
                },
                label = { Text( text="Descripcion")},
            )
            Row(modifier = Modifier.padding(start = 20.dp, top = 20.dp)) {
                Button(onClick = { dimiss() }) {
                    Text(text = "Cerrar")
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(onClick = { dimiss()
                    save(titulo.value, descripcion.value) }) {
                    Text(text = "Actualizar")
                }  
            }
           
        }

    }
}
@Composable
fun progressdialog(
    tareatitulo:String,
    tareaprogress:Float,
    dimiss:()->Unit,
    save:(Int)->Unit
){
    val progreso = rememberSaveable { mutableStateOf(tareaprogress)}

    Dialog(onDismissRequest = { dimiss() }) {
        Column(modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(10.dp)
            ) {
            Text(text = "$tareatitulo Progreso",fontSize = 20.sp,fontWeight = FontWeight.SemiBold, color = MaterialTheme.colors.primary)
            Spacer(modifier = Modifier.height(20.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(contentAlignment = Alignment.Center) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Slider(
                            value = progreso.value,
                            valueRange =  0f..100f,
                            onValueChange = {
                                progreso.value = it
                                            },
                            modifier = Modifier
                                .padding(end = 20.dp)
                                .weight(0.9f)
                        )
                        val progress = progreso.value.toInt().toString()
                        Text(text = "$progress%",maxLines = 1 ,
                            modifier = Modifier
                                .weight(0.1f)
                        )
                    }
                }

            }
            Row(modifier = Modifier.padding(start = 20.dp, top = 20.dp)) {
                Button(onClick = { dimiss() }) {
                    Text(text = "Cerrar")
                }
                Spacer(modifier = Modifier.width(20.dp))
                Button(onClick = { dimiss()
                    save(progreso.value.toInt()) }) {
                    Text(text = "Actualizar")
                }
            }
        }
    }

}

