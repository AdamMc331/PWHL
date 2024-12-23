package com.adammcneilly.pwhl.mobile.shared.domain.usecases

import com.adammcneilly.pwhl.mobile.shared.data.repositories.PWHLRepository
import com.adammcneilly.pwhl.mobile.shared.displaymodels.PlayByPlayEventDisplayModel
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayFaceOffEvent

/**
 * Fetches the play by play events for a specific game and maps
 * them into their display model entities.
 */
class FetchPlayByPlayUseCase(
    private val repository: PWHLRepository,
) {
    suspend fun invoke(
        gameId: String,
    ): Result<Map<String, List<PlayByPlayEventDisplayModel>>> {
        return repository.fetchPlayByPlay(gameId).map { eventList ->
            eventList
                .filter { event ->
                    event !is PlayByPlayFaceOffEvent
                }
                .map(PlayByPlayEvent::toDisplayModel)
                .groupBy { event ->
                    event.period.longName
                }
        }
    }
}
