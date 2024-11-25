package com.pwhl.mobile.shared.di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            repositoryModule,
            remoteModule,
            useCaseModule,
            utilModule,
            viewModelModule,
        )
    }
}
