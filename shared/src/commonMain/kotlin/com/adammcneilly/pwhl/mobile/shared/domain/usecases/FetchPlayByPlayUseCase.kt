package com.adammcneilly.pwhl.mobile.shared.domain.usecases

import com.adammcneilly.pwhl.mobile.shared.data.repositories.PWHLRepository
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent

class FetchPlayByPlayUseCase(
    private val repository: PWHLRepository,
) {
    suspend fun invoke(
        gameId: String,
    ): Result<List<PlayByPlayEventDisplayModel>> {
        return repository.fetchPlayByPlay(gameId).map { eventList ->
            eventList.map(PlayByPlayEvent::toDisplayModel)
        }
    }
}
