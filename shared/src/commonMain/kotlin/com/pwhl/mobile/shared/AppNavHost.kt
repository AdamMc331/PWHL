package com.pwhl.mobile.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Feed.route,
    ) {
        Screen.entries.forEach { screen ->
            composable(screen.route) {
                screen.render(modifier, navController)
            }
        }
    }
}
