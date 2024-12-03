package com.pwhl.mobile.shared.domain.usecases

import com.pwhl.mobile.shared.displaymodels.StandingsRowDisplayModel

class FetchStandingsUseCase {
    fun invoke(): Result<List<StandingsRowDisplayModel>> {
        return Result.success(emptyList())
    }
}
