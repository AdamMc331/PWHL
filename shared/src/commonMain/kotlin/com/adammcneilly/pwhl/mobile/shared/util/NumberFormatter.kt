package com.adammcneilly.pwhl.mobile.shared.util

expect fun numberFormatter(): NumberFormatter

/**
 * Right now there does not appear to be string formatting in the common code of Kotlin,
 * so we need platform specific string formatters to do this. Ideally we can remove this
 * at some point.
 */
interface NumberFormatter {
    /**
     *
     * A save percentage is a float formatted to three decimal points.
     */
    fun formatSavePercentage(
        value: Float,
    ): String
}
