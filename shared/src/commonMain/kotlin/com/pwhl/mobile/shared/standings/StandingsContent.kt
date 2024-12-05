package com.pwhl.mobile.shared.standings

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StandingsContent(
    state: StandingsState,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(state.standings) { standingsRow ->
            StandingsRowListItem(standingsRow)
        }
    }
}
