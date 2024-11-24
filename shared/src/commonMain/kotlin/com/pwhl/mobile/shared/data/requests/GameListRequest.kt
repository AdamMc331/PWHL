package com.pwhl.mobile.shared.data.requests

import kotlinx.datetime.Instant

data class GameListRequest(
    val beforeDate: Instant,
    val afterDate: Instant,
    val teamId: String?,
)
