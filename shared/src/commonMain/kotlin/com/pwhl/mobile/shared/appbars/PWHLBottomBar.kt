package com.pwhl.mobile.shared.appbars

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pwhl.mobile.shared.HomeTab

@Composable
fun PWHLBottomBar(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val tabs = remember {
        listOf(
            HomeTab.Feed,
            HomeTab.News,
            HomeTab.Standings,
            HomeTab.Profile,
        )
    }

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination

    NavigationBar(
        modifier = modifier,
    ) {
        tabs.forEach { tab ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == tab.route::class.qualifiedName } == true

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(tab.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().route.orEmpty()) {
                            saveState = true
                        }

                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true

                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = tab.getIcon(),
                        contentDescription = tab.getTitle(),
                    )
                },
            )
        }
    }
}
