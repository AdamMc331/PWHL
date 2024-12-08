package com.pwhl.mobile.shared.di

import com.pwhl.mobile.shared.feed.FeedViewModel
import com.pwhl.mobile.shared.gamedetail.GameDetailViewModel
import com.pwhl.mobile.shared.standings.StandingsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        FeedViewModel(
            recentGamesUseCase = get(),
            upcomingGamesUseCase = get(),
        )
    }

    viewModel { (gameId: String) ->
        GameDetailViewModel(gameId)
    }

    viewModel {
        StandingsViewModel(
            fetchStandingsUseCase = get(),
        )
    }
}
