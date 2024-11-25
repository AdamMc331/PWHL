package com.pwhl.mobile.shared.domain.usecases

import com.pwhl.mobile.shared.data.repositories.PWHLRepository
import com.pwhl.mobile.shared.data.requests.GameListRequest
import com.pwhl.mobile.shared.models.Game
import com.pwhl.mobile.shared.time.TimeProvider
import kotlin.time.Duration.Companion.days

class FetchUpcomingGamesUseCase(
    private val repository: PWHLRepository,
    private val timeProvider: TimeProvider,
) {
    suspend fun invoke(): Result<List<Game>> {
        val now = timeProvider.now()
        val beforeDate = now.plus(3.days)
        val request = GameListRequest(
            beforeDate = beforeDate,
            afterDate = now,
            teamId = null,
        )

        return repository.fetchGames(request)
    }
}
