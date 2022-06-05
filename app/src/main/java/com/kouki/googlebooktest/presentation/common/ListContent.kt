package com.kouki.googlebooktest.presentation.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kouki.googlebooktest.R
import com.kouki.googlebooktest.ui.theme.HERO_ITEM_HEIGHT
import com.kouki.googlebooktest.ui.theme.LARGE_PADDING

@ExperimentalCoilApi
@Composable
fun ListContent(
    title: String,
    url: String
) {

    Box(
        modifier = Modifier
            .height(HERO_ITEM_HEIGHT),
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(
            shape = RoundedCornerShape(
                size = LARGE_PADDING
            )
        ) {
            Text(text = title)
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
        }
    }
}