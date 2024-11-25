package com.pwhl.mobile.shared

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
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
                FeedScreen()
            }
        }
    }
}
