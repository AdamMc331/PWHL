package com.adammcneilly.pwhl.mobile.shared.util

expect fun numberFormatter(): NumberFormatter

interface NumberFormatter {
    /**
     * Right now there does not appear to be string formatting in the common code of Kotlin,
     * so we need platform specific string formatters to do this. Ideally we can remove this
     * at some point.
     */
    fun formatFloatTwoDecimalPlaces(
        value: Float,
    ): String
}
