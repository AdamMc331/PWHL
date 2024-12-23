package com.adammcneilly.pwhl.mobile.shared.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.materialkolor.rememberDynamicColorScheme

@Composable
fun PWHLTheme(
    seedColor: Color = PWHLColors.Purple,
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = rememberDynamicColorScheme(
        seedColor = seedColor,
        isDark = useDarkTheme,
        isAmoled = false,
    )

    val compactDimensions = Dimensions(
        componentHorizontalPadding = 8.dp,
        componentVerticalPadding = 8.dp,
    )

    CompositionLocalProvider(
        LocalDimensions provides compactDimensions,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = Shapes,
            content = content,
        )
    }
}

object PWHLTheme {
    val dimensions: Dimensions
        @Composable
        get() = LocalDimensions.current
}
