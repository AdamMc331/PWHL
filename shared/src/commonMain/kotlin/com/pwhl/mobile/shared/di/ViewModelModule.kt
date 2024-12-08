package com.pwhl.mobile.shared.di

import com.pwhl.mobile.shared.feed.FeedViewModel
import com.pwhl.mobile.shared.gamedetail.GameDetailViewModel
import com.pwhl.mobile.shared.standings.StandingsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        println("ADAMLOG - ???")
        FeedViewModel(
            recentGamesUseCase = get(),
            upcomingGamesUseCase = get(),
        )
    }

    viewModel { parameters ->
        println("ADAMLOG - PARAMS: $parameters")
        GameDetailViewModel(
            gameId = parameters.get(),
        )
    }

    viewModel {
        StandingsViewModel(
            fetchStandingsUseCase = get(),
        )
    }
}
