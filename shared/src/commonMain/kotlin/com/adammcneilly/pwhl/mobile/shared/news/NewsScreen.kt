package com.adammcneilly.pwhl.mobile.shared.news

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.pwhl.mobile.shared.ui.components.PWHLScreenScaffold
import kotlinx.serialization.Serializable

@Composable
fun NewsScreen(
    modifier: Modifier = Modifier,
) {
    PWHLScreenScaffold(
        title = "News",
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
