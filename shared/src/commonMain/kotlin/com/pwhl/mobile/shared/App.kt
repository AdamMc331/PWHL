package com.pwhl.mobile.shared

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.pwhl.mobile.shared.data.hockeytech.HockeyTechKtorClient
import com.pwhl.mobile.shared.data.hockeytech.HockeyTechPWHLService
import com.pwhl.mobile.shared.di.remoteModule
import com.pwhl.mobile.shared.di.repositoryModule
import com.pwhl.mobile.shared.di.useCaseModule
import com.pwhl.mobile.shared.di.utilModule
import com.pwhl.mobile.shared.di.viewModelModule
import com.pwhl.mobile.shared.displaymodels.GameDisplayModel
import com.pwhl.mobile.shared.domain.usecases.FetchUpcomingGamesUseCase
import com.pwhl.mobile.shared.feed.FeedScreen
import com.pwhl.mobile.shared.time.SystemTimeProvider
import com.pwhl.mobile.shared.ui.theme.PWHLTheme
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.KoinApplication

@Preview
@Composable
fun App() {
    KoinApplication(
        application = {
            modules(
                repositoryModule,
                remoteModule,
                useCaseModule,
                utilModule,
                viewModelModule,
            )
        },
    ) {
        var games by remember {
            mutableStateOf(emptyList<GameDisplayModel>())
        }

        val service = HockeyTechPWHLService(
            HockeyTechKtorClient,
            SystemTimeProvider,
        )
        rememberCoroutineScope().launch {
            val gamesList = FetchUpcomingGamesUseCase(
                repository = service,
                timeProvider = SystemTimeProvider,
            ).invoke().getOrNull()

            games = gamesList?.map(::GameDisplayModel).orEmpty()
        }

        PWHLTheme {
            Surface {
                FeedScreen()
//            LazyColumn {
//                items(games) { game ->
//                    GameListItem(game)
//
//                    HorizontalDivider()
//                }
//            }
            }
        }
    }
}
