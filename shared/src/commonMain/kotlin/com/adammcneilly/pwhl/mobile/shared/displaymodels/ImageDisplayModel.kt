package com.adammcneilly.pwhl.mobile.shared.displaymodels

import org.jetbrains.compose.resources.DrawableResource

sealed interface ImageDisplayModel {
    data class Remote(
        val url: String,
    ) : ImageDisplayModel

    data class Local(
        val resource: DrawableResource,
    ) : ImageDisplayModel

    data object Placeholder : ImageDisplayModel
}
