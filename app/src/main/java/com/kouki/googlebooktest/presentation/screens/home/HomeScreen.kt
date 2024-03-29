package com.kouki.googlebooktest.presentation.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.kouki.googlebooktest.navigation.Screen
import com.kouki.googlebooktest.presentation.common.BottomNavigationBar
import com.kouki.googlebooktest.presentation.common.GridContent

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val searchQuery by homeViewModel.searchQuery
    val items = homeViewModel.searchedBooks.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            SearchTopBar(
                text = searchQuery,
                onTextChange = {
                    homeViewModel.updateSearchQuery(query = it)
                },
                onSearchClicked = {
                    navController.navigate(Screen.Search.passKeyword(it))
                },
                onCloseClicked = {},
            )
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {
        GridContent(items, navController)
    }
}


