package com.kouki.googlebooktest.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.kouki.googlebooktest.Util.Constants.DETAILS_ARGUMENT_KEY
import com.kouki.googlebooktest.presentation.screens.Detail.DetailScreen
import com.kouki.googlebooktest.presentation.screens.Home.HomeScreen
import com.kouki.googlebooktest.presentation.screens.splash.SplashScreen

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ){
       composable(route = Screen.Splash.route){
            SplashScreen(navController = navController)
       }
        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY){
                // pass id
                type = NavType.StringType
            })
        ){
            DetailScreen(navController = navController)
        }
    }

}