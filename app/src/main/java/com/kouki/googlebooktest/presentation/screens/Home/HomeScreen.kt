package com.kouki.googlebooktest.presentation.screens.Home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import com.kouki.googlebooktest.R
import com.kouki.googlebooktest.domain.model.Items
import com.kouki.googlebooktest.navigation.Screen
import com.kouki.googlebooktest.presentation.common.ListContent

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
                    homeViewModel.searchBooks(query = it)
                },
                onCloseClicked = {}
            )
        }
    ) {
        ListContent(items, navController)
    }
}


