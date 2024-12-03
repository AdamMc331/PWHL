package com.pwhl.mobile.shared.data.hockeytech

import com.pwhl.mobile.shared.BuildKonfig
import com.pwhl.mobile.shared.data.hockeytech.dto.HockeyTechScoreBarResponseDTO
import com.pwhl.mobile.shared.data.hockeytech.dto.HockeyTechStandingsListResponseDTO
import com.pwhl.mobile.shared.data.remote.BaseKtorClient
import com.pwhl.mobile.shared.data.repositories.PWHLRepository
import com.pwhl.mobile.shared.data.requests.GameListRequest
import com.pwhl.mobile.shared.models.Game
import com.pwhl.mobile.shared.models.StandingsRow
import com.pwhl.mobile.shared.time.TimeProvider
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil

class HockeyTechPWHLService(
    private val apiClient: BaseKtorClient,
    private val timeProvider: TimeProvider,
) : PWHLRepository {
    override suspend fun fetchGames(
        request: GameListRequest,
    ): Result<List<Game>> {
        val endpoint = "feed/index.php"

        val now = timeProvider.now()
        val daysBack = request.afterDate.daysUntil(now, TimeZone.currentSystemDefault())
        val daysAhead = now.daysUntil(request.beforeDate, TimeZone.currentSystemDefault())

        val gameListParams = mapOf(
            PARAM_KEY_FEED to PARAM_VALUE_MODULE_KIT,
            PARAM_KEY_VIEW to PARAM_VALUE_SCORE_BAR,
            PARAM_KEY_DAYS_AHEAD to daysAhead.toString(),
            PARAM_KEY_DAYS_BACK to daysBack.toString(),
            PARAM_KEY_TEAM_ID to request.teamId.orEmpty(),
        )

        val params = HockeyTechKtorClient.baseHockeyTechParams + gameListParams

        return apiClient
            .getResponse<HockeyTechScoreBarResponseDTO>(
                endpoint = endpoint,
                params = params,
            )
            .map(HockeyTechScoreBarResponseDTO::parseGames)
    }

    override suspend fun fetchStandings(): Result<List<StandingsRow>> {
        val endpoint =
            "feed/index.php?feed=statviewfeed&view=teams&groupTeamsBy=division&context=overall&site_id=0&season=5&special=false&key=${BuildKonfig.PWHL_API_KEY}&client_code=pwhl&league_id=1&conference=-1&division=-1&sort=points&lang=en&fmt=json"

        return apiClient.getResponse<HockeyTechStandingsListResponseDTO>(
            endpoint = endpoint,
        ).map { standingsList ->
            standingsList.sections?.firstOrNull()?.data?.mapNotNull { data ->
                data?.parseStandingsRow()
            }.orEmpty()
        }
    }

    companion object {
        private const val PARAM_KEY_FEED = "feed"
        private const val PARAM_KEY_VIEW = "view"
        private const val PARAM_KEY_DAYS_AHEAD = "numberofdaysahead"
        private const val PARAM_KEY_DAYS_BACK = "numberofdaysback"
        private const val PARAM_KEY_TEAM_ID = "team_id"

        private const val PARAM_VALUE_MODULE_KIT = "modulekit"
        private const val PARAM_VALUE_SCORE_BAR = "scorebar"
    }
}
