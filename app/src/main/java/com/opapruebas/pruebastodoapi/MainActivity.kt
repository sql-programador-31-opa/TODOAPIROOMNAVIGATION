package com.opapruebas.pruebastodoapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.opapruebas.pruebastodoapi.navigation.AppNavigation
import com.opapruebas.pruebastodoapi.ui.theme.PruebasTODOApiTheme
import com.opapruebas.pruebastodoapi.viewmodel.TareaViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.ViewModelLifecycle


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
            .background(MaterialTheme.colors.primary)
            .size(55.dp))
}
@Composable
fun imgnot100(){
    Image(painter = painterResource(id = R.drawable.tarea), contentDescription ="imagen prueba",
        modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
            .size(55.dp))
}
@Composable
fun deleteimg(){
    Image(painter = painterResource(id = R.drawable.quitar), contentDescription ="icono delete", modifier =
    Modifier.clickable { }
        .clip(CircleShape)
        .background(MaterialTheme.colors.primary)
        .size(25.dp)
        )
}

@Composable
fun img(progress:Int){

    if (progress == 100){
        img100()
    }else{
        imgnot100()
    }

}



