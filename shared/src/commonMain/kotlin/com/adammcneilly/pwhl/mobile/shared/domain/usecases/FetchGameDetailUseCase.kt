package com.adammcneilly.pwhl.mobile.shared.domain.usecases

import com.adammcneilly.pwhl.mobile.shared.data.repositories.PWHLRepository
import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameDetailDisplayModel

/**
 * Fetches detailed information about a specific game and maps it into a display model.
 */
class FetchGameDetailUseCase(
    private val repository: PWHLRepository,
) {
    suspend fun invoke(
        gameId: String,
    ): Result<GameDetailDisplayModel> {
        return repository.fetchGameDetail(gameId).map { game ->
            GameDetailDisplayModel(game)
        }
    }
}
