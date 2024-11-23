package com.pwhl.mobile.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
