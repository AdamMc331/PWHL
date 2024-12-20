package com.adammcneilly.pwhl.mobile.shared.domain.usecases

import com.adammcneilly.pwhl.mobile.shared.data.repositories.PWHLRepository
import com.adammcneilly.pwhl.mobile.shared.displaymodels.GameDetailDisplayModelV2

class FetchGameDetailUseCase(
    private val repository: PWHLRepository,
) {
    suspend fun invoke(
        gameId: String,
    ): Result<GameDetailDisplayModelV2> {
        return repository.fetchGameDetail(gameId).map { game ->
            GameDetailDisplayModelV2(game)
        }
    }
}
