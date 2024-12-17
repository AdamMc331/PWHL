package com.adammcneilly.pwhl.mobile.shared.di

import com.adammcneilly.pwhl.mobile.shared.data.hockeytech.HockeyTechKtorClient
import com.adammcneilly.pwhl.mobile.shared.data.remote.BaseKtorClient
import org.koin.dsl.module

val remoteModule = module {
    single<BaseKtorClient> {
        HockeyTechKtorClient
    }
}
