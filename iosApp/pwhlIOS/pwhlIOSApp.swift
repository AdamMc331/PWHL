//
//  pwhlIOSApp.swift
//  pwhlIOS
//
//  Created by Adam McNeilly on 9/24/24.
//

import shared
import SwiftUI

@main
struct pwhlIOSApp: App {

    init() {
        KoinInitializerKt.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
