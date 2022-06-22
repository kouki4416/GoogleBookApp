package com.kouki.googlebooktest.presentation.common

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kouki.googlebooktest.navigation.Screen

@Composable
fun BottomBar (navController: NavHostController){
        BottomNavigation {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            Screen.bottomNavScreens.forEach{ screen ->
                BottomNavigationItem(
                    selected = currentDestination?.hierarchy?.any{it.route == screen.route } == true,
                    onClick = {
                        navController.navigate(screen.route){
                            launchSingleTop = true
                        }
                    },
                    label = {

                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = screen.icon),
                            contentDescription = "BottomNavIcon"
                        )
                    },
                    alwaysShowLabel = false
                )
            }
        }
}