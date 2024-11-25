package com.pwhl.mobile.shared.di

import com.pwhl.mobile.shared.data.hockeytech.HockeyTechPWHLService
import com.pwhl.mobile.shared.data.repositories.PWHLRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PWHLRepository> {
        HockeyTechPWHLService(
            apiClient = get(),
            timeProvider = get(),
        )
    }
}
