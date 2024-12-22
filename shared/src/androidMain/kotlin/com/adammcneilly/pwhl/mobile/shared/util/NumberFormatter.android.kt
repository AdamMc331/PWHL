package com.adammcneilly.pwhl.mobile.shared.util

actual fun numberFormatter(): NumberFormatter {
    return AndroidNumberFormatter()
}

private class AndroidNumberFormatter : NumberFormatter {
    override fun formatSavePercentage(
        value: Float,
    ): String {
        return "%.3f".format(value)
    }
}
