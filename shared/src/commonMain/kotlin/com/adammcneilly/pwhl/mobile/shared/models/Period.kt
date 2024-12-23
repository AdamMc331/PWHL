package com.adammcneilly.pwhl.mobile.shared.models

data class Period(
    val id: String,
    val shortName: String,
    val longName: String,
) {
    // Remove after Detekt is updated: https://github.com/detekt/detekt/pull/7635/
    @Suppress("UndocumentedPublicClass")
    companion object {
        val Shootout = Period(
            id = "Shootout",
            shortName = "Shootout",
            longName = "Shootout",
        )
    }
}
