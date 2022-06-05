package com.kouki.googlebooktest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.kouki.googlebooktest.presentation.screens.Home.HomeScreen
import com.kouki.googlebooktest.presentation.screens.splash.SplashScreen

@ExperimentalCoilApi
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
    }

}