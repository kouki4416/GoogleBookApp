package com.kouki.googlebooktest.presentation.screens.detail

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.AsyncImage
import com.kouki.googlebooktest.R
import com.kouki.googlebooktest.Util.Constants.ABOUT_TEXT_MAX_LINE
import com.kouki.googlebooktest.Util.Constants.MIN_BACKGROUND_IMAGE_HEIGHT
import com.kouki.googlebooktest.domain.model.BookDetail
import com.kouki.googlebooktest.domain.model.ImageLinks
import com.kouki.googlebooktest.ui.theme.*

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun DetailContent(
    navController: NavHostController,
    selectedBook: BookDetail,
) {
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Expanded)
    )

    val currentSheetFraction = scaffoldState.currentSheetFraction

    val radiusAnim by animateDpAsState(
        targetValue = if (currentSheetFraction == 1f) EXTRA_LARGE_PADDING else EXPANDED_RADIUS_LEVEL
    )

    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(
            topStart = radiusAnim,
            topEnd = radiusAnim
        ),
        scaffoldState = scaffoldState,
        sheetPeekHeight = MIN_SHEET_HEIGHT,
        sheetContent = {
            BottomSheetContent(
                selectedBook
            )
        },
        content = {
            Log.d("book", getImageLink(selectedBook.volumeInfo?.imageLinks))

            BackgroundContent(
                bookImage = getImageLink(selectedBook.volumeInfo?.imageLinks)
            )
        }
    )

}

@Composable
fun BottomSheetContent(
    selectedBook: BookDetail,
    infoBoxIconColor: Color = MaterialTheme.colors.primary,
    sheetBackgroundColor: Color = MaterialTheme.colors.primary,
    contentColor: Color = Color.DarkGray
) {
    Column(
        modifier = Modifier
            .background(sheetBackgroundColor)
            .padding(all = LARGE_PADDING)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = LARGE_PADDING),
            verticalAlignment = Alignment.CenterVertically
        ){
            // title
            Text(
                modifier = Modifier
                    .weight(8f),
                text = selectedBook.volumeInfo?.title ?: "No Title",
                color = contentColor,
                fontSize = MaterialTheme.typography.h4.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
        //Log.d("book", selectedBook.volumeInfo?.description!!)
        // Description
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Description",
            color = contentColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .alpha(ContentAlpha.medium)
                .padding(bottom = MEDIUM_PADDING),
            text = selectedBook.volumeInfo?.description ?: "No Description",
            color = Color.Black,
            fontSize = MaterialTheme.typography.body1.fontSize,
            maxLines = ABOUT_TEXT_MAX_LINE
        )
    }
}

@ExperimentalCoilApi
@Composable
fun BackgroundContent(
    bookImage: String?,
    imageFraction: Float = 1f
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(fraction = imageFraction + MIN_BACKGROUND_IMAGE_HEIGHT)
                .align(Alignment.TopStart),
            model = bookImage,
            placeholder = painterResource(id = R.drawable.ic_placeholder),
            contentDescription = null,
            onError = { it -> Log.d("", it.toString()) }
        )
    }
}


private fun getImageLink(imageLinks: ImageLinks?): String{
    if(imageLinks == null){
        Log.d("book", "not image link")
        return ""
    }
    if(imageLinks.large != null){
        return imageLinks.large
    } else if(imageLinks.medium != null){
        return imageLinks.medium
    } else if(imageLinks.small != null){
        return imageLinks.small
    } else if(imageLinks.thumbnail != null){
        return imageLinks.thumbnail
    } else{
        return ""
    }
}

@ExperimentalMaterialApi
val BottomSheetScaffoldState.currentSheetFraction: Float
    get() {
        val fraction = bottomSheetState.progress.fraction
        val targetValue = bottomSheetState.targetValue
        val currentValue = bottomSheetState.currentValue

        return when {
            currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Collapsed -> 1f
            currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Expanded -> 0f
            currentValue == BottomSheetValue.Collapsed && targetValue == BottomSheetValue.Expanded -> 1f - fraction
            currentValue == BottomSheetValue.Expanded && targetValue == BottomSheetValue.Collapsed -> 0f + fraction
            else -> fraction
        }
    }