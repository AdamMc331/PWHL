package com.adammcneilly.pwhl.mobile.shared.time

import kotlinx.datetime.Instant

interface TimeProvider {
    fun now(): Instant
}
