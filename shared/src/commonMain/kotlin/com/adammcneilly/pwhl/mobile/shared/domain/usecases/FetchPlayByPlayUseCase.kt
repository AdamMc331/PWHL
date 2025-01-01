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
                .also { pbpEvents ->
                    println("ADAMLOG - MAX X: ${pbpEvents.maxOf { it.xLocation ?: 0 }}")
                    println("ADAMLOG - MAX Y: ${pbpEvents.maxOf { it.yLocation ?: 0 }}")
                    println("ADAMLOG - MIN X: ${pbpEvents.minOf { it.xLocation ?: 0 }}")
                    println("ADAMLOG - MIN Y: ${pbpEvents.minOf { it.yLocation ?: 0 }}")
                }
                .groupBy { event ->
                    event.period.longName
                }
        }
    }
}
