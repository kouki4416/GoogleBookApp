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
import com.kouki.googlebooktest.presentation.screens.bookshelf.BookshelfScreen
import com.kouki.googlebooktest.presentation.screens.home.HomeScreen
import com.kouki.googlebooktest.presentation.screens.mypage.MyPageScreen
import com.kouki.googlebooktest.presentation.screens.ranking.RankingScreen
import com.kouki.googlebooktest.presentation.screens.top.TopScreen
import com.kouki.googlebooktest.presentation.screens.splash.SplashScreen
import com.kouki.googlebooktest.presentation.screens.store.StoreScreen

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
        composable(
            route = Screen.Top.route
        ){
            TopScreen(navController = navController)
        }
        composable(
            route = Screen.Store.route
        ){
            StoreScreen(navController = navController)
        }
        composable(
            route = Screen.Ranking.route
        ){
            RankingScreen(navController = navController)
        }
        composable(
            route = Screen.Bookshelf.route
        ){
            BookshelfScreen(navController = navController)
        }
        composable(
            route = Screen.MyPage.route
        ){
            MyPageScreen(navController = navController)
        }
    }

}