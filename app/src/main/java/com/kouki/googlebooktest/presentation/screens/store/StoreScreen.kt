package com.kouki.googlebooktest.presentation.screens.store

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.kouki.googlebooktest.presentation.common.BottomBar
import com.kouki.googlebooktest.presentation.screens.top.TopScreenTopBar

@Composable
fun StoreScreen(navController: NavHostController) {
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