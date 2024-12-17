package com.adammcneilly.pwhl.mobile.shared

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.adammcneilly.pwhl.mobile.shared.appbars.PWHLBottomBar
import com.adammcneilly.pwhl.mobile.shared.di.appModules
import com.adammcneilly.pwhl.mobile.shared.ui.theme.PWHLTheme
import org.koin.compose.KoinApplication

@Composable
fun App() {
    KoinApplication(
        application = {
            modules(appModules)
        },
    ) {
        PWHLTheme {
            val navController = rememberNavController()

            Scaffold(
                bottomBar = {
                    PWHLBottomBar(
                        navController = navController,
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
