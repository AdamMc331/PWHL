package com.pwhl.mobile.shared

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector

enum class HomeTab(
    val label: String,
    val icon: ImageVector,
) {
    Feed(
        label = "Home",
        icon = Icons.Default.Home,
    ),
    News(
        label = "News",
        icon = Icons.Default.Info,
    ),
    Standings(
        label = "Standings",
        icon = Icons.Default.Info,
    ),
}
