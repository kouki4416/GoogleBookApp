package com.kouki.googlebooktest.presentation.common

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
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
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

//@ExperimentalCoilApi
//@Composable
//fun ListContent(
//    books: LazyPagingItems<Books>,
//    navController: NavHostController
//) {
//
//    Box(
//        modifier = Modifier
//            .height(BOOK_ITEM_HEIGHT),
//        contentAlignment = Alignment.BottomStart
//    ) {
//        LazyColumn(
//            contentPadding = PaddingValues(all = SMALL_PADDING),
//            verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
//        ) {
//            items(
//                items = books,
//                key = { books ->
//                    books.items
//                }
//            ) { items ->
//                items?.let {
//                    BookItem(items = it, navController =)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun BookItem(
//    items: Items,
//    navController: NavHostController
//) {
//    Box(
//        modifier = Modifier
//            .height(BOOK_ITEM_HEIGHT),
//        //TODO add clickable,
//        contentAlignment = Alignment.BottomStart
//    ) {
//        Surface(
//            shape = RoundedCornerShape(
//                size = LARGE_PADDING
//            )
//        ) {
//            // get book image using coil
//            AsyncImage(
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data("http://books.google.com/books/content?id=I4C7AAAAIAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api")
//                    .crossfade(true)
//                    .build(),
//                placeholder = painterResource(R.drawable.ic_placeholder),
//                contentDescription = "image",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier.clip(CircleShape)
//            )
//        }
//
//        androidx.compose.material.Surface(
//            modifier = Modifier
//                .fillMaxHeight(0.4f)
//                .fillMaxWidth(),
//            color = Color.Black.copy(alpha = ContentAlpha.medium),
//            shape = RoundedCornerShape(
//                bottomStart = LARGE_PADDING,
//                bottomEnd = LARGE_PADDING
//            )
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(all = MEDIUM_PADDING)
//            ) {
//                //TODO add necessary info for book
//                Text(text = title)
//            }
//        }
//
//    }
//
//}