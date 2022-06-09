package com.kouki.googlebooktest.presentation.common

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import androidx.paging.compose.itemsIndexed
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kouki.googlebooktest.R
import com.kouki.googlebooktest.domain.model.Books
import com.kouki.googlebooktest.domain.model.Items
import com.kouki.googlebooktest.ui.theme.BOOK_ITEM_HEIGHT
import com.kouki.googlebooktest.ui.theme.LARGE_PADDING
import com.kouki.googlebooktest.ui.theme.MEDIUM_PADDING
import com.kouki.googlebooktest.ui.theme.SMALL_PADDING

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
                modifier = Modifier
                    .fillMaxSize(),
                model = item.volumeInfo?.imageLinks?.thumbnail,
                placeholder = painterResource(id = R.drawable.ic_placeholder),
                contentDescription = null,
                onError = {it -> Log.d("", it.toString())}
            )
        }
    }
}