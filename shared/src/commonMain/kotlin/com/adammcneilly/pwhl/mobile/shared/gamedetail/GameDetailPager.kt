package com.adammcneilly.pwhl.mobile.shared.gamedetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GameDetailPager(
    modifier: Modifier = Modifier,
) {
    val tabs = GameDetailTab.entries

    val pagerState = rememberPagerState {
        tabs.size
    }

    Column(
        modifier = modifier,
    ) {
        GameDetailTabRow(
            pagerState = pagerState,
        )

        HorizontalPager(
            state = pagerState,
        ) { pageIndex ->
            val pageModifier = Modifier
                .fillMaxSize()

            when (tabs[pageIndex]) {
                GameDetailTab.Summary -> GameDetailSummaryTab(
                    modifier = pageModifier,
                )
                GameDetailTab.Stats -> GameDetailStatsTab(
                    modifier = pageModifier,
                )
                GameDetailTab.PlayByPlay -> GameDetailPlayByPlayTab(
                    modifier = pageModifier,
                )
            }
        }
    }
}
