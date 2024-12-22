package com.adammcneilly.pwhl.mobile.shared.util

actual fun numberFormatter(): NumberFormatter {
    return AndroidNumberFormatter()
}

private class AndroidNumberFormatter : NumberFormatter {
    override fun formatFloatTwoDecimalPlaces(
        value: Float,
    ): String {
        return "%.2f".format(value)
    }
}
