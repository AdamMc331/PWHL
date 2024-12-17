package com.adammcneilly.pwhl.mobile.shared.di

import com.adammcneilly.pwhl.mobile.shared.data.hockeytech.HockeyTechPWHLService
import com.adammcneilly.pwhl.mobile.shared.data.repositories.PWHLRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PWHLRepository> {
        HockeyTechPWHLService(
            apiClient = get(),
            timeProvider = get(),
        )
    }
}
