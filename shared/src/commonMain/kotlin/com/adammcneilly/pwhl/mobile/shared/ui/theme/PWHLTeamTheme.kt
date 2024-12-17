package com.adammcneilly.pwhl.mobile.shared.ui.theme

import androidx.compose.runtime.Composable

@Composable
fun PWHLTeamTheme(
    teamId: String,
    content: @Composable () -> Unit,
) {
    val seedColor = PWHLColors.fromTeamId(teamId)

    PWHLTheme(
        seedColor = seedColor,
        content = content,
    )
}
