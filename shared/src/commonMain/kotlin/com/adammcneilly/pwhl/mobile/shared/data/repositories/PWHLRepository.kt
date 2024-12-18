package com.adammcneilly.pwhl.mobile.shared.data.repositories

import com.adammcneilly.pwhl.mobile.shared.data.requests.GameListRequest
import com.adammcneilly.pwhl.mobile.shared.models.GameDetail
import com.adammcneilly.pwhl.mobile.shared.models.GameSummary
import com.adammcneilly.pwhl.mobile.shared.models.StandingsRow
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent

interface PWHLRepository {
    suspend fun fetchGames(
        request: GameListRequest,
    ): Result<List<GameDetail>>

    suspend fun fetchStandings(): Result<List<StandingsRow>>

    suspend fun fetchGameSummary(
        gameId: String,
    ): Result<GameSummary>

    suspend fun fetchPlayByPlay(
        gameId: String,
    ): Result<List<PlayByPlayEvent>>
}
