package com.example.navegation2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.navegacion.views.DetailView


@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController=navController, starDestination = "home"){
        composable("home"){
            HomeView(navController)
        }
        composable("Detail/{id}/?{opcional}", arguments= listOf(
            navArgument("id"){type= NavType.IntType},
            navArgument("opcional"){type = NavType.StringType},
        )){
            val id = it.arguments?.getInt("id") ?: 0
            val opcional = it.arguments?.getString("opcional")?: ""
            DetailView(navController, id , opcional)
        }
    }
}

fun rememberNavController(): Any {
    TODO("Not yet implemented")
}
