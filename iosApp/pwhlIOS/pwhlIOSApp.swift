//
//  pwhlIOSApp.swift
//  pwhlIOS
//
//  Created by Adam McNeilly on 9/24/24.
//

import SwiftUI

@main
struct pwhlIOSApp: App {

    init() {
        KoinInitializerKt.initKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
