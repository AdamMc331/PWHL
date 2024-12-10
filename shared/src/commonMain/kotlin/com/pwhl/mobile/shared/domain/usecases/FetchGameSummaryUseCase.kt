package com.pwhl.mobile.shared.domain.usecases

import com.pwhl.mobile.shared.data.repositories.PWHLRepository
import com.pwhl.mobile.shared.displaymodels.GameSummaryDisplayModel

class FetchGameSummaryUseCase(
    private val repository: PWHLRepository,
) {
    suspend fun invoke(
        gameId: String,
    ): Result<GameSummaryDisplayModel> {
        return repository.fetchGameSummary(gameId).map { game ->
            GameSummaryDisplayModel(game)
        }
    }
}
