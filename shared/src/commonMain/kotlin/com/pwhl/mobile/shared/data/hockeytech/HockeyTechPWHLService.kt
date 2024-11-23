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

        val gameListParams = mapOf(
            PARAM_KEY_FEED to PARAM_VALUE_MODULE_KIT,
            PARAM_KEY_VIEW to PARAM_VALUE_SCORE_BAR,
            PARAM_KEY_DAYS_AHEAD to "6",
            PARAM_KEY_DAYS_BACK to "0",
        )

        val params = HockeyTechKtorClient.baseHockeyTechParams + gameListParams

        return apiClient
            .getResponse<HockeyTechScoreBarResponseDTO>(
                endpoint = endpoint,
                params = params,
            )
            .map(HockeyTechScoreBarResponseDTO::parseGames)
    }

    companion object {
        private const val PARAM_KEY_FEED = "feed"
        private const val PARAM_KEY_VIEW = "view"
        private const val PARAM_KEY_DAYS_AHEAD = "numberofdaysahead"
        private const val PARAM_KEY_DAYS_BACK = "numberofdaysback"

        private const val PARAM_VALUE_MODULE_KIT = "modulekit"
        private const val PARAM_VALUE_SCORE_BAR = "scorebar"
    }
}
