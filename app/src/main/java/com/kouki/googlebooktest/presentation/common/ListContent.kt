package com.kouki.googlebooktest.presentation.common

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import com.kouki.googlebooktest.R
import com.kouki.googlebooktest.domain.model.ImageLinks
import com.kouki.googlebooktest.domain.model.Items
import com.kouki.googlebooktest.domain.model.VolumeInfo
import com.kouki.googlebooktest.navigation.Screen
import com.kouki.googlebooktest.ui.theme.BOOK_ITEM_HEIGHT
import com.kouki.googlebooktest.ui.theme.LARGE_PADDING
import com.kouki.googlebooktest.ui.theme.MEDIUM_PADDING

// 一列一つのリスト
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
        ) { _, item ->
            val id = item?.id
            item?.volumeInfo?.let {
                BookItem(volumeInfo = it, bookId = id, navController = navController)
            }
        }
    }
}

// Gridバージョンのリスト
// https://developer.android.com/jetpack/compose/lists
// ページングと使う場合の参考 https://stackoverflow.com/questions/68445699/how-to-use-jetpack-compose-paging-with-lazyverticalgrid
@Composable
fun GridContent(
    itemList: LazyPagingItems<Items>,
    navController: NavHostController
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 5.dp)
    ) {
        items(itemList.itemCount) { index ->
            val item = itemList[index]
            item?.volumeInfo?.let {
                BookItem(volumeInfo = it, bookId = item.id , navController = navController)
            }
        }
    }
}

@Composable
fun BookItem(
    volumeInfo: VolumeInfo,
    bookId: String?,
    navController: NavHostController
) {

    // create each post UI
    Box(
        modifier = Modifier
            .height(BOOK_ITEM_HEIGHT)
            .clickable {
                navController.navigate(Screen.Detail.passBookId(bookId!!))
            }
        ,
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(
            shape = RoundedCornerShape(
                size = LARGE_PADDING
            )
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize(),
                model = volumeInfo.imageLinks?.thumbnail,
                placeholder = painterResource(id = R.drawable.ic_placeholder),
                contentDescription = null,
                onError = { it -> Log.d("", it.toString()) }
            )
        }

        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = MEDIUM_PADDING)
            ) {
                Text(
                    text = volumeInfo.title ?: "",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis // three dots
                )
                Text(
                    text = volumeInfo.description ?: "",
                    color = Color.White.copy(alpha = ContentAlpha.medium),
                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis // three dots
                )
            }
        }
    }
}

@Preview
@Composable
@ExperimentalCoilApi
fun BookItemPreview() {
    val volumeInfo = VolumeInfo(
        title = "映画HELLO WORLD公式ビジュアルガイド",
        description = "現実と仮想...過去と未来...交錯する2つの世界。映画の感動と興奮、物語の真の姿を解きほぐすガイドブック。",
        imageLinks = ImageLinks(
            smallThumbnail = "http://books.google.com/books/content?id=6zhQygEACAAJ&printsec=frontcover&img=1&zoom=5&source=gbs_api",
            thumbnail = "http://books.google.com/books/content?id=6zhQygEACAAJ&printsec=frontcover&img=1&zoom=1&source=gbs_api"
        )
    )

    //BookItem(volumeInfo = volumeInfo, navController = null)
}