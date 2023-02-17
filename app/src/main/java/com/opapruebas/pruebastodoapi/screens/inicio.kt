package com.opapruebas.pruebastodoapi.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.opapruebas.pruebastodoapi.navigation.AppScreens


@Composable
fun inicio(navController: NavController){
        Scaffold() {
                TopAppBar(modifier = Modifier.fillMaxHeight(0.3f)) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(text = "MI OPA DEMO",fontSize = 50.sp, fontWeight = FontWeight.Bold, modifier = Modifier.align(alignment = Alignment.Center).background(color = MaterialTheme.colors.primary), color = Color.White)
                    }
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
            Button(onClick = {
                navController.navigate(route = AppScreens.todo.route)
            }, colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary ,
                contentColor = Color.White
            ) , modifier = Modifier
                .width(230.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(25.dp))) {
                Text(text = "TODO APP", fontSize = 40.sp,color=Color.White)
            }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            navController.navigate(route = AppScreens.apimain.route)
        }, colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = Color.White
        ), modifier = Modifier
            .width(230.dp)
            .height(100.dp)
            .clip(RoundedCornerShape(25.dp))) {
            Text(text = "API APP", fontSize = 40.sp,color=Color.White)
        }

    }
}
