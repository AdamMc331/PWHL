package com.pwhl.mobile.shared.di

import com.pwhl.mobile.shared.time.SystemTimeProvider
import com.pwhl.mobile.shared.time.TimeProvider
import org.koin.dsl.module

val utilModule = module {
    single<TimeProvider> {
        SystemTimeProvider
    }
}
