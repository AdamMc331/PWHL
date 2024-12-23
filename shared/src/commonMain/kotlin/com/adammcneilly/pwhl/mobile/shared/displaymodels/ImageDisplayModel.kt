package com.adammcneilly.pwhl.mobile.shared.displaymodels

import com.adammcneilly.pwhl.mobile.shared.Res
import com.adammcneilly.pwhl.mobile.shared.pwhl
import org.jetbrains.compose.resources.DrawableResource

sealed interface ImageDisplayModel {
    data class Remote(
        val url: String,
    ) : ImageDisplayModel

    data class Local(
        val resource: DrawableResource,
    ) : ImageDisplayModel

    // Remove after Detekt is updated: https://github.com/detekt/detekt/pull/7635/
    @Suppress("UndocumentedPublicClass")
    companion object {
        val Placeholder = Local(
            resource = Res.drawable.pwhl,
        )
    }
}
