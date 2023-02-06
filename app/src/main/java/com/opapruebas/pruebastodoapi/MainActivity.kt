package com.opapruebas.pruebastodoapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.opapruebas.pruebastodoapi.navigation.AppNavigation
import com.opapruebas.pruebastodoapi.ui.theme.PruebasTODOApiTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebasTODOApiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()
                }

            }
        }
    }
}

@Composable
fun img(){
    Image(painter = painterResource(id = R.drawable.tareaimg), contentDescription ="imagen prueba",
        modifier = Modifier
            .padding(10.dp)
            .size(60.dp))
}


@Preview(showSystemUi = true)
@Composable
fun precompo(){
    AppNavigation()

}