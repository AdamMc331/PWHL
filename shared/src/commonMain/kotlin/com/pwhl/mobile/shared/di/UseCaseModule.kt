package com.pwhl.mobile.shared.di

import com.pwhl.mobile.shared.domain.usecases.FetchRecentGamesUseCase
import com.pwhl.mobile.shared.domain.usecases.FetchUpcomingGamesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single {
        FetchRecentGamesUseCase(
            repository = get(),
            timeProvider = get(),
        )
    }

    single {
        FetchUpcomingGamesUseCase(
            repository = get(),
            timeProvider = get(),
        )
    }
}
