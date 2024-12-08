package com.pwhl.mobile.shared.standings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinNavViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@Composable
@OptIn(KoinExperimentalAPI::class)
fun StandingsScreen(
    modifier: Modifier = Modifier,
    viewModel: StandingsViewModel = koinNavViewModel(),
) {
    val state = viewModel.state.collectAsState()

    StandingsContent(state.value, modifier)
}

@Serializable
object StandingsScreen
