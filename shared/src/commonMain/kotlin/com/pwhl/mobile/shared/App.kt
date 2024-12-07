package com.pwhl.mobile.shared

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.pwhl.mobile.shared.appbars.PWHLBottomBar
import com.pwhl.mobile.shared.appbars.PWHLTopBar
import com.pwhl.mobile.shared.di.appModules
import com.pwhl.mobile.shared.ui.theme.PWHLTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Preview
@Composable
fun App() {
    KoinApplication(
        application = {
            modules(appModules)
        },
    ) {
        PWHLTheme {
            val navController = rememberNavController()
            val currentBackStackEntry = navController.currentBackStackEntryFlow.collectAsState(null)

            Scaffold(
                topBar = {
                    PWHLTopBar(
                        title = currentBackStackEntry.value?.title().orEmpty(),
                    )
                },
                bottomBar = {
                    PWHLBottomBar(
                        tabs = HomeTab.entries,
                        selectedTab = currentBackStackEntry.value?.homeTab() ?: HomeTab.Feed,
                        onTabClicked = { tab ->
                            navController.navigate(tab.screen.route) {
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
                    )
                },
            ) { scaffoldPadding ->
                AppNavHost(
                    navController = navController,
                    modifier = Modifier
                        .padding(scaffoldPadding)
                        .fillMaxSize(),
                )
            }
        }
    }
}

private fun NavBackStackEntry.homeTab(): HomeTab? {
    return HomeTab.entries.firstOrNull { tab ->
        tab.screen == this.screen()
    }
}

private fun NavBackStackEntry.screen(): Screen? {
    return Screen.entries.firstOrNull { screen ->
        screen.route == destination.route
    }
}

private fun NavBackStackEntry.title(): String {
    return this.screen()?.title.orEmpty()
}
