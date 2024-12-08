package com.pwhl.mobile.shared.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PWHLScreenScaffold(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        topBar = {
            PWHLTopBar(
                title = title,
            )
        },
        modifier = modifier,
    ) { scaffoldPadding ->
        content(scaffoldPadding)
    }
}
