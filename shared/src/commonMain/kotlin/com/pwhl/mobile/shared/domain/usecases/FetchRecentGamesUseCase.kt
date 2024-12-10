package com.pwhl.mobile.shared.domain.usecases

import com.pwhl.mobile.shared.data.repositories.PWHLRepository
import com.pwhl.mobile.shared.data.requests.GameListRequest
import com.pwhl.mobile.shared.models.GameDetail
import com.pwhl.mobile.shared.time.TimeProvider
import kotlin.time.Duration.Companion.days

class FetchRecentGamesUseCase(
    private val repository: PWHLRepository,
    private val timeProvider: TimeProvider,
) {
    suspend fun invoke(): Result<List<GameDetail>> {
        val now = timeProvider.now()
        val afterDate = now.minus(7.days)
        val request = GameListRequest(
            beforeDate = now,
            afterDate = afterDate,
            teamId = null,
        )

        return repository.fetchGames(request)
    }
}
