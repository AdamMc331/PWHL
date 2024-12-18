package com.adammcneilly.pwhl.mobile.shared.domain.usecases

import com.adammcneilly.pwhl.mobile.shared.data.repositories.PWHLRepository
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel

class FetchPlayByPlayUseCase(
    private val repository: PWHLRepository,
) {
    suspend fun invoke(
        gameId: String,
    ): Result<List<PlayByPlayEventDisplayModel>> {
        val events = repository.fetchPlayByPlay(gameId)

        TODO("Parse events")
    }
}
