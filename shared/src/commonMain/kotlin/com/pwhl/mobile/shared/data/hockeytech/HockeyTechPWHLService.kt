package com.pwhl.mobile.shared.data.hockeytech

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
            HockeyTechParameterKeys.FEED to "modulekit",
            HockeyTechParameterKeys.VIEW to "scorebar",
            HockeyTechParameterKeys.DAYS_AHEAD to daysAhead.toString(),
            HockeyTechParameterKeys.DAYS_BACK to daysBack.toString(),
            HockeyTechParameterKeys.TEAM_ID to request.teamId.orEmpty(),
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
        val endpoint = "feed/index.php"

        val standingsParams = mapOf(
            HockeyTechParameterKeys.FEED to "statviewfeed",
            HockeyTechParameterKeys.VIEW to "teams",
            HockeyTechParameterKeys.GROUP_TEAMS_BY to "division",
            HockeyTechParameterKeys.CONTEXT to "overall",
            HockeyTechParameterKeys.SEASON to "5", // TODO: Needed?
            HockeyTechParameterKeys.SPECIAL to "false", // TODO: What?
            HockeyTechParameterKeys.SORT to "points",
        )

        val params = HockeyTechKtorClient.baseHockeyTechParams + standingsParams

        return apiClient.getResponse<HockeyTechStandingsListResponseDTO>(
            endpoint = endpoint,
            params = params,
        ).map { standingsList ->
            standingsList.sections?.firstOrNull()?.data?.mapNotNull { data ->
                data?.parseStandingsRow()
            }.orEmpty()
        }
    }
}
