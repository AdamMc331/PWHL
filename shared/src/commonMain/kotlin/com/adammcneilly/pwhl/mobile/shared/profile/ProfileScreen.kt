package com.adammcneilly.pwhl.mobile.shared.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.pwhl.mobile.shared.ui.components.PWHLScreenScaffold
import kotlinx.serialization.Serializable

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    PWHLScreenScaffold(
        title = "Profile",
        modifier = modifier,
    ) { scaffoldPadding ->
        Text(
            text = "Profile Content Stub",
            modifier = Modifier
                .padding(scaffoldPadding),
        )
    }
}

@Serializable
object ProfileScreen
