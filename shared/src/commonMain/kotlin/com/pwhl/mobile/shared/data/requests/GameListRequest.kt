package com.pwhl.mobile.shared.data.requests

import kotlinx.datetime.Instant

data class GameListRequest(
    val before: Instant,
    val after: Instant,
)
