package com.adammcneilly.pwhl.mobile.shared.domain.usecases

import com.adammcneilly.pwhl.mobile.shared.data.repositories.PWHLRepository
import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameDetailDisplayModel

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
