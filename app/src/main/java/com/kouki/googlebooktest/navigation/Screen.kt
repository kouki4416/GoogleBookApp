package com.kouki.googlebooktest.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash_screen")
    object Home: Screen("home_screen")
    object Detail: Screen("detail_screen/{bookId}"){
        fun passBookId(bookId: String): String{
            return "detail_screen/$bookId"
        }
    }
}