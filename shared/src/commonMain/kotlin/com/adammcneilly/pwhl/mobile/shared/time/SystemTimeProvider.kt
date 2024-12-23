package com.adammcneilly.pwhl.mobile.shared.time

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

/**
 * This implementation of [TimeProvider] will always return the current system time.
 */
object SystemTimeProvider : TimeProvider {
    override fun now(): Instant {
        return Clock.System.now()
    }
}
