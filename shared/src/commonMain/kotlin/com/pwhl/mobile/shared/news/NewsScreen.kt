package com.pwhl.mobile.shared.news

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pwhl.mobile.shared.ui.components.PWHLTopBar
import kotlinx.serialization.Serializable

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            PWHLTopBar(
                title = "News",
            )
        },
        modifier = modifier,
    ) { scaffoldPadding ->
        Text(
            text = "News Content Stub",
            modifier = Modifier
                .padding(scaffoldPadding),
        )
    }
}

@Serializable
object NewsScreen
