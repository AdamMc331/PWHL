package com.pwhl.mobile.shared.profile

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Profile Screen Stub",
        modifier = modifier,
    )
}

@Serializable
object ProfileScreen
