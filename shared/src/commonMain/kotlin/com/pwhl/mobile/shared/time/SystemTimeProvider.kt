package com.pwhl.mobile.shared.time

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

object SystemTimeProvider : TimeProvider {
    override fun now(): Instant {
        return Clock.System.now()
    }
}
