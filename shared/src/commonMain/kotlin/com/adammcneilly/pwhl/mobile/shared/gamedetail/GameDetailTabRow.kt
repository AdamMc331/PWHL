package com.adammcneilly.pwhl.mobile.shared.gamedetail

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun GameDetailTabRow(
    selectedTab: GameDetailTab,
    onTabClick: (GameDetailTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    TabRow(
        selectedTabIndex = selectedTab.ordinal,
        modifier = modifier,
    ) {
        GameDetailTab.entries.forEach { tab ->
            Tab(
                selected = (tab == selectedTab),
                onClick = {
                    onTabClick.invoke(tab)
                },
                text = {
                    Text(
                        text = tab.getLabel(),
                    )
                },
            )
        }
    }
}
