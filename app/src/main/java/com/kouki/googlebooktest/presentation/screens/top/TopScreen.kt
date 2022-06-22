package com.kouki.googlebooktest.presentation.screens.top

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kouki.googlebooktest.navigation.Screen
import com.kouki.googlebooktest.presentation.common.BottomBar

@Composable
fun TopScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopScreenTopBar()
        },
        bottomBar = {
            BottomBar(navController)
        }
    ) {

    }
}


@Composable
fun TopScreenTopBar(){

}


