package com.pwhl.mobile.shared

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.rememberNavController
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

private fun NavBackStackEntry.title(): String {
    val screen = Screens.entries.firstOrNull { screen ->
        screen.route == destination.route
    }

    return screen?.title.orEmpty()
}
