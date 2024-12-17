package com.adammcneilly.pwhl.mobile.shared.standings

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.pwhl.mobile.shared.ui.components.LoadingScreen

@Composable
fun StandingsContent(
    state: StandingsState,
    modifier: Modifier = Modifier,
) {
    if (state.isLoading) {
        LoadingScreen(modifier)
    } else {
        SuccessContent(modifier, state)
    }
}

@Composable
private fun SuccessContent(
    modifier: Modifier,
    state: StandingsState,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(state.standings) { standingsRow ->
            StandingsRowListItem(standingsRow)

            HorizontalDivider()
        }
    }
}
