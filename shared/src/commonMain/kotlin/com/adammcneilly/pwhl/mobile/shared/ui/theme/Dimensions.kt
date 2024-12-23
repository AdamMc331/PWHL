package com.adammcneilly.pwhl.mobile.shared.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

val LocalDimensions = staticCompositionLocalOf {
    Dimensions(
        componentHorizontalPadding = 0.dp,
        componentVerticalPadding = 0.dp,
        imageSizeDefault = 0.dp,
    )
}

@Immutable
data class Dimensions(
    val componentHorizontalPadding: Dp,
    val componentVerticalPadding: Dp,
    val imageSizeDefault: Dp,
) {
    val componentPadding: PaddingValues
        get() = PaddingValues(
            horizontal = componentHorizontalPadding,
            vertical = componentVerticalPadding,
        )

    companion object {
        private val compact = Dimensions(
            componentHorizontalPadding = 8.dp,
            componentVerticalPadding = 8.dp,
            imageSizeDefault = 48.dp,
        )

        private val medium = Dimensions(
            componentHorizontalPadding = 8.dp,
            componentVerticalPadding = 8.dp,
            imageSizeDefault = 48.dp,
        )

        private val expanded = Dimensions(
            componentHorizontalPadding = 16.dp,
            componentVerticalPadding = 16.dp,
            imageSizeDefault = 72.dp,
        )

        val immersive = Dimensions(
            componentHorizontalPadding = 16.dp,
            componentVerticalPadding = 16.dp,
            imageSizeDefault = 96.dp,
        )

        fun get(
            windowSizeClass: WindowSizeClass,
        ): Dimensions {
            return when (windowSizeClass.widthSizeClass) {
                WindowWidthSizeClass.Compact -> compact
                WindowWidthSizeClass.Medium -> medium
                WindowWidthSizeClass.Expanded -> expanded
                else -> compact
            }
        }
    }
}
