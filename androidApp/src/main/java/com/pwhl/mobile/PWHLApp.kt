package com.pwhl.mobile

import android.app.Application
import com.pwhl.mobile.shared.di.initKoin

class PWHLApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin()
    }
}
