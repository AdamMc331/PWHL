package com.adammcneilly.pwhl.mobile.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.adammcneilly.pwhl.mobile.shared.PWHLApp

/**
 * This Activity is the main entry point for our Android application, opened
 * when the user clicks the app icon.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(
        savedInstanceState: Bundle?,
    ) {
        super.onCreate(savedInstanceState)

        setContent {
            enableEdgeToEdge()

            PWHLApp()
        }
    }
}
