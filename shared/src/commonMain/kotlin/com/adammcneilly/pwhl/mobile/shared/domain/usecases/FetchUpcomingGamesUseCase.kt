package com.adammcneilly.pwhl.mobile.shared.domain.usecases

import com.adammcneilly.pwhl.mobile.shared.data.repositories.PWHLRepository
import com.adammcneilly.pwhl.mobile.shared.data.requests.GameListRequest
import com.adammcneilly.pwhl.mobile.shared.models.GameSummary
import com.adammcneilly.pwhl.mobile.shared.time.TimeProvider
import kotlin.time.Duration.Companion.days

class FetchUpcomingGamesUseCase(
    private val repository: PWHLRepository,
    private val timeProvider: TimeProvider,
) {
    suspend fun invoke(): Result<List<GameSummary>> {
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
