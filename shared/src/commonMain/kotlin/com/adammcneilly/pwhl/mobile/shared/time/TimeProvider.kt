package com.adammcneilly.pwhl.mobile.shared.time

import kotlinx.datetime.Instant

/**
 * Interface to provide a specific moment in time. This is highly
 * beneficial as an interface so unit tests can mock the current time.
 */
interface TimeProvider {
    fun now(): Instant
}
