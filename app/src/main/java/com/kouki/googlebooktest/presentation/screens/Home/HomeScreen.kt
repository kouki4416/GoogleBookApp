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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kouki.googlebooktest.R
import com.kouki.googlebooktest.domain.model.Items

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
//    val response by homeViewModel.myResponse
//    var imageUrl:String? = null
//    var title:String? = null
//    var list: ArrayList<Int>
//
//    if(response?.isSuccessful == true){
//       imageUrl =  response!!.body()!!.items[0].volumeInfo?.imageLinks?.thumbnail.toString()
//        title =  response!!.body()!!.items[0].volumeInfo?.title.toString()
//    }
//    Scaffold(
//        topBar = {
//
//        },
//        content = {
//            // TODO carefully check null here
//            if(response != null && response!!.body() != null){
//                ListContent(response!!.body()!!)
//            }
//        }
//    )
    val items = homeViewModel.getBooks().collectAsLazyPagingItems()
    Scaffold(
        topBar = {

        }
    ) {
        ListContent(items, navController)
    }
}

@Composable
fun ListContent(
    items: LazyPagingItems<Items>,
    navController: NavHostController
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(
            items = items
        ) { _, post ->
            post?.let {
                BookItem(item = it, navController = navController)
            }
        }
    }
}

@Composable
fun BookItem(
    item: Items,
    navController: NavHostController
) {
    Log.d("",item.volumeInfo?.imageLinks?.thumbnail ?: "empty")
    // create each post UI
    Box(
        modifier = Modifier
            .height(200.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(
            shape = RoundedCornerShape(
                size = 20.dp
            )
        ) {
            AsyncImage(
                model = item.volumeInfo?.imageLinks?.thumbnail!!,
                placeholder = painterResource(id = R.drawable.ic_placeholder),
                contentDescription = null,
                onError = {it -> Log.d("", it.toString())}
            )
        }
        Text(
            //text = item.volumeInfo?.title ?: "failed",
            text = item.volumeInfo?.imageLinks?.thumbnail!!,
            color = MaterialTheme.colors.primary,
        )
    }
}
