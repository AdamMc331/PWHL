package com.pwhl.mobile.shared.news

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
) {
    Text(
        text = "News Screen Stub",
        modifier = modifier,
    )
}

@Serializable
object NewsScreen
