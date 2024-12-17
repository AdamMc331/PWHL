package com.adammcneilly.pwhl.mobile.shared.appbars

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.adammcneilly.pwhl.mobile.shared.HomeTab

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

    val selectedTab = tabs.find { tab ->
        (currentDestination?.route == tab.route::class.qualifiedName)
    }

    AnimatedVisibility(
        visible = (selectedTab != null),
        enter = fadeIn() + slideInVertically(
            initialOffsetY = { it / 2 },
        ),
        exit = fadeOut() + slideOutVertically(
            targetOffsetY = { it / 2 },
        ),
    ) {
        NavigationBar(
            modifier = modifier,
        ) {
            tabs.forEach { tab ->
                val isSelected = (tab == selectedTab)

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
}
