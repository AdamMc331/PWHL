package com.pwhl.mobile.shared.data.hockeytech

import com.pwhl.mobile.shared.data.hockeytech.dto.HockeyTechScoreBarResponseDTO
import com.pwhl.mobile.shared.data.remote.BaseKtorClient
import com.pwhl.mobile.shared.data.repositories.PWHLRepository
import com.pwhl.mobile.shared.data.requests.GameListRequest
import com.pwhl.mobile.shared.models.Game

class HockeyTechPWHLService(
    private val apiClient: BaseKtorClient = HockeyTechKtorClient,
) : PWHLRepository {
    override suspend fun fetchGames(request: GameListRequest): Result<List<Game>> {
        val endpoint = "feed/index.php"

        val params = mapOf(
            "feed" to "modulekit",
            "key" to "1234",
            "client_code" to "pwhl",
            "view" to "scorebar",
            "numberofdaysahead" to "6",
            "numberofdaysback" to "0",
            "limit" to "1000",
            "fmt" to "json",
            "site_id" to "0",
            "league_id" to "1",
        )

        return apiClient
            .getResponse<HockeyTechScoreBarResponseDTO>(
                endpoint,
                params,
            ).map(HockeyTechScoreBarResponseDTO::parseGames)
    }
}
