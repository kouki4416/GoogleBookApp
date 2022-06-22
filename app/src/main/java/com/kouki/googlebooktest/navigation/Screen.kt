package com.kouki.googlebooktest.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import com.kouki.googlebooktest.R

sealed class Screen(val route: String) {
    val icon = R.drawable.ic_icons8_google_books
    object Splash: Screen("splash_screen")
    object Home: Screen("home_screen")
    object Detail: Screen("detail_screen/{bookId}"){
        fun passBookId(bookId: String): String{
            return "detail_screen/$bookId"
        }
    }
    object Top: Screen("top_screen")
    object Store: Screen("store_screen")
    object Ranking: Screen("ranking_screen")
    object MyPage: Screen("mypage_screen")
    object Bookshelf: Screen("bookshelf_screen")

    companion object {
        val bottomNavScreens = listOf(
            Top,
            Store,
            Ranking,
            MyPage,
            Bookshelf
        )
    }
}