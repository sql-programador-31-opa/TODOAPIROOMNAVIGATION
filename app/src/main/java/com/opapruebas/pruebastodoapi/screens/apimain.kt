package com.opapruebas.pruebastodoapi.screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.opapruebas.pruebastodoapi.data.Personaje
import com.opapruebas.pruebastodoapi.data.Personajes
import com.opapruebas.pruebastodoapi.rmbg
import com.opapruebas.pruebastodoapi.viewmodel.RickAndMortyViewModel
import kotlinx.coroutines.flow.collectLatest


@Composable
fun apimain(navController: NavController, viewModel: RickAndMortyViewModel = hiltViewModel()){
        Cuerpoapimain(navController,viewModel)
}

@Composable
fun Cuerpoapimain(navController: NavController,viewModel:RickAndMortyViewModel) {
    val state = viewModel.state
    val eventFlow =viewModel.eventFlow
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true ){

        eventFlow.collectLatest {
            event->
            when(event){
                is RickAndMortyViewModel.uiEvent.ShowSnackBar->{
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }
    Scaffold(scaffoldState = scaffoldState,
    topBar = {
            HomeTopBar()
    },
    bottomBar = {
        HomeBottomBar(
            showPreview = state.showPrevious,
            ShowNext = state.showNext,
            onPreviusPressed = { viewModel.getPersonajes(false) },
            onNextPressed = {viewModel.getPersonajes(true) }
        )
    }) { innerPadding->
        HomeContent(
            isLoading = state.isLoading,
            Personajes = state.personajes)
    }

}


@Composable
fun HomeContent(
    isLoading: Boolean = false,
    Personajes: List<Personajes> = emptyList()
) {

Surface(modifier = Modifier
    .fillMaxSize()
    .padding(bottom = 50.dp), color = MaterialTheme.colors.surface) {
LazyColumn(contentPadding = PaddingValues(vertical = 15.dp), modifier = Modifier.fillMaxSize(), content ={
items(Personajes.size){
index->
    val pj:Personajes  = Personajes[index]

    Card(elevation = 10.dp, shape = RoundedCornerShape(10.dp), modifier = Modifier.padding(horizontal = 20.dp)) {
    Row() {
            Column(modifier = Modifier
                .weight(0.2f)
                .padding(8.dp)
                .border(border = BorderStroke(5.dp, color = Color.Cyan)),
                Arrangement.Center) {
                AsyncImage(model = pj.img, contentDescription ="", contentScale = ContentScale.Crop)
            }
            Column(modifier = Modifier
                .weight(0.8f)
                .padding(7.dp)) {
                Text( fontSize = 30.sp,text = Personajes[index].name, color = Color.Cyan)
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = Personajes[index].specie)
            }
        }
    }
    Spacer(modifier = Modifier.height(10.dp))
}
} )
    if (isLoading) FullScreenLoading()
    
}
}
@Composable
private fun FullScreenLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Column() {
            CircularProgressIndicator(color = Color.Cyan)
            Text(text = "Cargando" ,color = Color.Cyan, fontSize = 15.sp)
        }

    }
}

@Composable
fun HomeBottomBar(
    showPreview:Boolean,
    ShowNext:Boolean,
    onPreviusPressed:()-> Unit,
    onNextPressed:()-> Unit
) {
    Surface(
        modifier= Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            TextButton(modifier= Modifier
                .weight(1f)
                .height(48.dp), enabled = showPreview, onClick =  onPreviusPressed ) {
                Text(text = "Anterior")
            }
            TextButton(modifier= Modifier
                .weight(1f)
                .height(48.dp), enabled = ShowNext, onClick =  onNextPressed ) {
                Text(text = "Siguiente")
            }
        }

    }
}

@Composable
fun HomeTopBar() {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f),
        backgroundColor = Color.Transparent

    ){
        rmbg()
    }
}
