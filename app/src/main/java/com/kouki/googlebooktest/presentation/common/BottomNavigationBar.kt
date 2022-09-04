package com.kouki.googlebooktest.presentation.common

import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kouki.googlebooktest.navigation.Screen

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    //  NavHost 関数から NavController の状態をホイスティングし、BottomNavigation コンポーネントと共有
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        Screen.bottomNavigationScreens.forEachIndexed { index, screen ->
            NavigationBarItem(
                onClick = {
                    navController.navigate(screen.route){
                        // 同じ画面は一つまでしかスタックされない
                        this.launchSingleTop = true
                        this.restoreState = true
                    }
                },
                icon = { Icon(Icons.Filled.Favorite, contentDescription = screen.screenName) },
                label = { Text(screen.screenName) },
                selected = currentDestination?.hierarchy?.any{ it.route == screen.route } == true
            )
        }
    }
}
