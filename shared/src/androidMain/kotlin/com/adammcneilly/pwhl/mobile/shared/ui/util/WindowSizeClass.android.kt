package com.adammcneilly.pwhl.mobile.shared.ui.util

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
actual fun currentWindowSizeClass(): WindowSizeClass {
    return calculateWindowSizeClass(
        activity = (LocalContext.current as ComponentActivity),
    )
}
