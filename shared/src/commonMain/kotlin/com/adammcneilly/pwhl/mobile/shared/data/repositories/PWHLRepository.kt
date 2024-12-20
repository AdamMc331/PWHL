package com.adammcneilly.pwhl.mobile.shared.data.repositories

import com.adammcneilly.pwhl.mobile.shared.data.requests.GameListRequest
import com.adammcneilly.pwhl.mobile.shared.models.GameDetail
import com.adammcneilly.pwhl.mobile.shared.models.GameDetailV2
import com.adammcneilly.pwhl.mobile.shared.models.StandingsRow
import com.adammcneilly.pwhl.mobile.shared.models.playbyplay.PlayByPlayEvent

interface PWHLRepository {
    suspend fun fetchGames(
        request: GameListRequest,
    ): Result<List<GameDetail>>

    suspend fun fetchStandings(): Result<List<StandingsRow>>

    suspend fun fetchGameDetail(
        gameId: String,
    ): Result<GameDetailV2>

    suspend fun fetchPlayByPlay(
        gameId: String,
    ): Result<List<PlayByPlayEvent>>
}
