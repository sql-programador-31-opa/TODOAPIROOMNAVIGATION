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
import androidx.compose.ui.graphics.Color
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
dimiss:()->Unit,
save:(String)->Unit
){
    val titulo = rememberSaveable { mutableStateOf(tareatitulo.value)}
    Dialog(onDismissRequest = {dimiss()}) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .clip(RoundedCornerShape(25.dp))
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(RoundedCornerShape(25.dp))) {
                Column(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .align(alignment = Alignment.TopCenter)
                ) {
                   Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(10.dp)) {
                       Row(verticalAlignment = Alignment.CenterVertically) {
                           Box(modifier = Modifier.weight(1f)) {
                               Text(
                                   text = "Editar Datos de la Tarea",
                                   fontSize = 35.sp,
                                   fontWeight = FontWeight.SemiBold,
                                   color = MaterialTheme.colors.primary,
                                   modifier = Modifier.align(alignment = Alignment.Center)

                               )
                           }

                       }
                       Spacer(modifier = Modifier.height(15.dp))
                       Row() {
                           OutlinedTextField(
                               value = titulo.value,
                               onValueChange = { tituloe ->
                                   titulo.value = tituloe
                               },
                               label = { Text(text = "Titulo",color = MaterialTheme.colors.primary,fontSize = 20.sp) },
                               maxLines = 1,
                               modifier = Modifier.weight(1f)
                           )
                       }
                   }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(modifier = Modifier.padding(10.dp)) {
                        Button(onClick = { dimiss() }, modifier = Modifier
                            .width(80.dp)
                            .weight(0.5f),
                            colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Gray ,
                            contentColor = Color.White
                        ) ) {
                            Text(text = "Cancelar")
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Button(onClick = {
                            dimiss()
                            save(titulo.value)
                        }, modifier = Modifier
                            .width(80.dp)
                            .weight(0.5f),
                            colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.primary ,
                            contentColor = Color.White
                        ) ) {
                            Text(text = "Actualizar")
                        }
                    }

                }

            }
        }
    }
}

@Composable
fun progressdialog(
    tareatitulo:String,
    dimiss:()->Unit,
    save:()->Unit
) {

    Dialog(onDismissRequest = { dimiss() }) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .clip(RoundedCornerShape(25.dp))
                .padding(5.dp)
        ) {
            Column(modifier = Modifier.padding(25.dp)) {
                Text(text = "Esta seguro de actualizar el progreso?")
                Row(modifier = Modifier.padding(5.dp)) {
                    Box(Modifier.fillMaxWidth()) {
                        Text(
                            text = "$tareatitulo",
                            fontSize = 40.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colors.primary,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                }
                Row(modifier = Modifier.padding(start = 20.dp, top = 20.dp)) {
                    Button(onClick = { dimiss() }, modifier = Modifier
                        .width(80.dp)
                        .weight(0.5f),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Gray ,
                            contentColor = Color.White
                        ) ) {
                        Text(text = "Cancelar")
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button( onClick = {
                        dimiss()
                        save()
                    }, modifier = Modifier
                        .width(80.dp)
                        .weight(0.5f),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.primary ,
                            contentColor = Color.White
                        ) ) {
                        Text(text = "Actualizar")
                    }
                }
            }


        }
    }

}

@Composable
fun deletedialog(
    tareatitulo:String,
    dimiss:()->Unit,
    delete:()->Unit
){
    Dialog(onDismissRequest = { dimiss() }) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .clip(RoundedCornerShape(25.dp))
                .padding(5.dp)
        ) {
            Column(modifier = Modifier.padding(25.dp)) {
                    Text(text = "Esta seguro de Eliminar?")
                Row(modifier = Modifier.padding(5.dp)) {
                    Box(Modifier.fillMaxWidth()) {
                        Text(
                            text = "$tareatitulo",
                            fontSize = 40.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colors.secondary,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }

                }
                Row(modifier = Modifier.padding(start = 20.dp, top = 20.dp)) {
                    Button(onClick = { dimiss() }, modifier = Modifier
                        .width(80.dp)
                        .weight(0.5f),
                        colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Gray ,
                        contentColor = Color.White
                    ) ) {
                        Text(text = "Cancelar")
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Button( onClick = {
                        dimiss()
                        delete()
                    }, modifier = Modifier
                        .width(80.dp)
                        .weight(0.5f),
                            colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.secondary ,
                            contentColor = Color.White
                        ) ) {
                        Text(text = "Eliminar")
                    }
                }
            }


        }
    }
}


