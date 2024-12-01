package com.pwhl.mobile.shared

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pwhl.mobile.shared.di.appModules
import com.pwhl.mobile.shared.feed.FeedScreen
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
            Surface {
                AppNavContainer(
                    modifier = Modifier
                        .fillMaxSize(),
                )
            }
        }
    }
}

@Composable
private fun AppNavContainer(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "feed",
    ) {
        composable("feed") {
            FeedScreen(modifier)
        }
    }
}
