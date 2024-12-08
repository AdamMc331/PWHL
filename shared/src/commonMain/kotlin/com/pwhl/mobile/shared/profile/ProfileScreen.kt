package com.pwhl.mobile.shared.profile

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pwhl.mobile.shared.ui.components.PWHLTopBar
import kotlinx.serialization.Serializable

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            PWHLTopBar(
                title = "Profile",
            )
        },
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
