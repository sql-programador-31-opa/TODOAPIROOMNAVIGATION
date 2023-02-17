package com.opapruebas.pruebastodoapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.opapruebas.pruebastodoapi.navigation.AppNavigation
import com.opapruebas.pruebastodoapi.navigation.AppScreens
import com.opapruebas.pruebastodoapi.ui.theme.PruebasTODOApiTheme
import com.opapruebas.pruebastodoapi.viewmodel.TareaViewModel
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val homeViewModel: TareaViewModel by viewModels()

        super.onCreate(savedInstanceState)
        setContent {
            PruebasTODOApiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation(homeViewModel)
                }

            }
        }
    }
}

@Composable
fun img100(){
    Image(painter = painterResource(id = R.drawable.great), contentDescription ="imagen prueba",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.secondary)
            .size(55.dp))
}
@Composable
fun imgnot100(){
    Image(painter = painterResource(id = R.drawable.tarea), contentDescription ="imagen prueba",
        modifier = Modifier

            .size(25.dp))
}
@Composable
fun deleteimg(){
    Image(painter = painterResource(id = R.drawable.basura), contentDescription ="icono delete", modifier =
    Modifier
        .size(55.dp)
        )
}
@Composable
fun editimg(){
    Image(painter = painterResource(id = R.drawable.editar), contentDescription ="icono edit", modifier =
    Modifier
        .size(55.dp)
    )
}

@Composable
fun addimg(navController: NavController){
    Image(painter = painterResource(id = R.drawable.agregar), contentDescription ="icono agregar", modifier =
    Modifier
        .clickable { navController.navigate(route = AppScreens.addtodo.route) }
        .clip(CircleShape)
        .size(20.dp)
    )
}

@Composable
fun rmbg(){
    Box() {
        Image(painter = painterResource(id = R.drawable.rick_mortybg), contentDescription ="BackgroundAPI", modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
        Column(modifier = Modifier
            .align(alignment = Alignment.BottomCenter)
            .background(MaterialTheme.colors.background.copy(0.95f))
            .fillMaxWidth()) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(text = "API DEMO", color = Color.Cyan, fontSize = 60.sp, modifier = Modifier.align(Alignment.BottomCenter))
            }

        }

    }

}

@Composable
fun img(progress:Boolean){

    if (progress == true){
        img100()
    }else{
        imgnot100()
    }

}
@Composable
@Preview
fun previewf(){
    rmbg()
}



