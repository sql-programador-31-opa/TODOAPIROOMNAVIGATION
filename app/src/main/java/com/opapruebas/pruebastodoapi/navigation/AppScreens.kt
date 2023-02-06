package com.opapruebas.pruebastodoapi.navigation

sealed class AppScreens(val route:String){
    object inicio:AppScreens("inicio")
    object todo:AppScreens("todo")
    object addtodo:AppScreens("addtodo")
    object apimain:AppScreens("apimain")
}
