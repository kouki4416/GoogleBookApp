package com.kouki.googlebooktest.presentation.screens.detail

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi

@Composable
@ExperimentalMaterialApi
@ExperimentalCoilApi
fun DetailScreen(
    navController: NavHostController,
    detailViewModel: DetailViewModel = hiltViewModel()
){
    val selectedBook by detailViewModel.selectedBook.collectAsState()
    if(selectedBook != null){
        DetailContent(navController = navController, selectedBook = selectedBook!!)
    }
}