package com.adammcneilly.pwhl.mobile.shared.gamedetail.playbyplay

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel

@Composable
fun PlayByPlayList(
    events: List<PlayByPlayEventDisplayModel>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(events) { event ->
            PlayByPlayListItem(event)

            HorizontalDivider()
        }
    }
}
