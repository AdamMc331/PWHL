package com.pwhl.mobile.shared.appbars

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pwhl.mobile.shared.HomeTab

@Composable
fun PWHLBottomBar(
    tabs: List<HomeTab>,
    selectedTab: HomeTab,
    onTabClicked: (HomeTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
    ) {
        tabs.forEach { tab ->
            NavigationBarItem(
                selected = (tab == selectedTab),
                onClick = {
                    onTabClicked.invoke(tab)
                },
                icon = {
                    Icon(
                        imageVector = tab.icon,
                        contentDescription = tab.label,
                    )
                },
            )
        }
    }
}
