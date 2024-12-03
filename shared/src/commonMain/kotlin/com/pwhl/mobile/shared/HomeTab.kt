package com.pwhl.mobile.shared

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Feed
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Feed
import androidx.compose.material.icons.filled.Newspaper
import androidx.compose.material.icons.filled.SportsHockey
import androidx.compose.ui.graphics.vector.ImageVector

enum class HomeTab(
    val screen: Screen,
    val icon: ImageVector,
) {
    Feed(
        screen = Screen.Feed,
        icon = Icons.Default.SportsHockey,
    ),
    News(
        screen = Screen.News,
        icon = Icons.Default.Newspaper,
    ),
    Standings(
        screen = Screen.Standings,
        icon = Icons.Default.BarChart,
    ),
    Profile(
        screen = Screen.Profile,
        icon = Icons.Default.AccountCircle,
    ),
}
