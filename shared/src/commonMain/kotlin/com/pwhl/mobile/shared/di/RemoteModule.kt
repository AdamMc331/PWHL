package com.pwhl.mobile.shared.di

import com.pwhl.mobile.shared.data.hockeytech.HockeyTechKtorClient
import com.pwhl.mobile.shared.data.remote.BaseKtorClient
import org.koin.dsl.module

val remoteModule = module {
    single<BaseKtorClient> {
        HockeyTechKtorClient
    }
}
