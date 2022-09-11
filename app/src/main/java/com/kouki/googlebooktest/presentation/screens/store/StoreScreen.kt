package com.kouki.googlebooktest.presentation.screens.store

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kouki.googlebooktest.presentation.common.BottomNavigationBar
import com.kouki.googlebooktest.presentation.common.CardMaterial
import com.kouki.googlebooktest.presentation.common.ExpandableCard
import com.kouki.googlebooktest.presentation.common.TopBar

@Composable
fun StoreScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ){
        CardMaterial()
        ExpandableCard(
            title = "title",
            descriptionText = "content"
        )
    }
}


