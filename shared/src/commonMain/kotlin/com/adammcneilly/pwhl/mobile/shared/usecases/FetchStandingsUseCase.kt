package com.adammcneilly.pwhl.mobile.shared.domain.usecases

import com.adammcneilly.pwhl.mobile.shared.data.repositories.PWHLRepository
import com.adammcneilly.pwhl.mobile.shared.displaymodels.StandingsRowDisplayModel

class FetchStandingsUseCase(
    private val repository: PWHLRepository,
) {
    suspend fun invoke(): Result<List<StandingsRowDisplayModel>> {
        return repository.fetchStandings()
            .map { standingsList ->
                standingsList.map(::StandingsRowDisplayModel)
            }
    }
}
