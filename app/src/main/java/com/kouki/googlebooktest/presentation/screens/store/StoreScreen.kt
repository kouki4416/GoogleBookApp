package com.kouki.googlebooktest.presentation.screens.store

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.kouki.googlebooktest.presentation.common.BottomNavigationBar
import com.kouki.googlebooktest.presentation.common.TopBar

@Composable
fun StoreScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopBar(
                menuItems = listOf(),
                onClick = { it -> }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) {

    }
}
