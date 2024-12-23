package com.adammcneilly.pwhl.mobile.shared.gamedetail.playbyplay

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.ui.theme.PWHLTheme

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun PlayByPlayList(
    events: Map<String, List<PlayByPlayEventDisplayModel>>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
    ) {
        events.forEach { (periodName, pbpEvents) ->
            stickyHeader {
                Text(
                    text = periodName,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = MaterialTheme.colorScheme.secondaryContainer,
                        )
                        .padding(PWHLTheme.dimensions.componentPadding),
                )
            }

            items(pbpEvents) { event ->
                PlayByPlayListItem(event)

                HorizontalDivider()
            }
        }
    }
}
