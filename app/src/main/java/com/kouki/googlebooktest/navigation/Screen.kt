package com.kouki.googlebooktest.navigation

import androidx.compose.ui.input.key.Key.Companion.Home
import com.kouki.googlebooktest.R

sealed class Screen(val route: String, val screenName: String) {
    val icon = R.drawable.ic_icons8_google_books

    object Splash : Screen("splash_screen", "Splash")
    object Detail : Screen("detail_screen/{bookId}", "Detail") {
        fun passBookId(bookId: String): String {
            return "detail_screen/$bookId"
        }
    }
    object Search : Screen("search_screen/{keyword}", "Search"){
        fun passKeyword(keyword: String): String{
            return "search_screen/$keyword"
        }
    }

    object Home : Screen("home_screen", "Home")
    object Store : Screen("store_screen", "Store")
    object Ranking : Screen("ranking_screen", "Ranking")
    object MyPage : Screen("mypage_screen", "MyPage")
    object Bookshelf : Screen("bookshelf_screen", "Bookshelf")

    companion object {
        val bottomNavigationScreens = listOf(
            Home,
            Store,
            Ranking,
            MyPage,
            Bookshelf
        )
    }
}