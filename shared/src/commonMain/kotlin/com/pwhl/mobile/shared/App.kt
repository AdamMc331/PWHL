package com.pwhl.mobile.shared

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.pwhl.mobile.shared.data.hockeytech.HockeyTechPWHLService
import com.pwhl.mobile.shared.data.requests.GameListRequest
import com.pwhl.mobile.shared.displaymodels.GameDisplayModel
import com.pwhl.mobile.shared.ui.components.GameListItem
import com.pwhl.mobile.shared.ui.theme.PWHLTheme
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.time.Duration.Companion.days

@Preview
@Composable
fun App() {
    var games by remember {
        mutableStateOf(emptyList<GameDisplayModel>())
    }

    val service = HockeyTechPWHLService()
    rememberCoroutineScope().launch {
        val request = GameListRequest(
            beforeDate = Clock.System.now().plus(6.days),
            afterDate = Clock.System.now().minus(3.days),
            teamId = null,
        )
        val gamesList = service.fetchGames(request).getOrNull()

        games = gamesList?.map(::GameDisplayModel).orEmpty()
    }

    PWHLTheme {
        Surface {
            LazyColumn {
                items(games) { game ->
                    GameListItem(game)

                    HorizontalDivider()
                }
            }
        }
    }
}
