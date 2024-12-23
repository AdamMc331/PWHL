package com.adammcneilly.pwhl.mobile.shared.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val LocalDimensions = staticCompositionLocalOf {
    Dimensions(
        componentHorizontalPadding = 0.dp,
        componentVerticalPadding = 0.dp,
    )
}

@Immutable
data class Dimensions(
    val componentHorizontalPadding: Dp,
    val componentVerticalPadding: Dp,
) {
    val componentPadding: PaddingValues
        get() = PaddingValues(
            horizontal = componentHorizontalPadding,
            vertical = componentVerticalPadding,
        )
}
