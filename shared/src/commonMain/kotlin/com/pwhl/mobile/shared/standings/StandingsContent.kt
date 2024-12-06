package com.pwhl.mobile.shared.standings

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
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
        itemsIndexed(state.standings) { index, standingsRow ->
            StandingsRowListItem(standingsRow)

            if (index != state.standings.lastIndex) {
                HorizontalDivider()
            }
        }
    }
}
