package com.pwhl.mobile.shared.data.repositories

import com.pwhl.mobile.shared.data.requests.GameListRequest
import com.pwhl.mobile.shared.models.Game
import com.pwhl.mobile.shared.models.StandingsRow

interface PWHLRepository {
    suspend fun fetchGames(
        request: GameListRequest,
    ): Result<List<Game>>

    suspend fun fetchStandings(): Result<List<StandingsRow>>
}
