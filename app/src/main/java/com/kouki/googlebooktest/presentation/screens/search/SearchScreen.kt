package com.kouki.googlebooktest.presentation.screens.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.kouki.googlebooktest.presentation.common.GridContent
import com.kouki.googlebooktest.presentation.screens.home.HomeViewModel
import com.kouki.googlebooktest.presentation.screens.home.SearchTopBar

@ExperimentalCoilApi
@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {

    val searchQuery by searchViewModel.searchQuery
    val items = searchViewModel.searchedBooks.collectAsLazyPagingItems()

    Scaffold(
        topBar = {

        },
    ) {
        GridContent(items, navController)
    }
}
