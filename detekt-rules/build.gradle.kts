plugins {
    id("kotlin")
    alias(libs.plugins.detekt)
}

dependencies {
    compileOnly(libs.detekt.api)

    testImplementation(kotlin("test"))
    testImplementation(libs.assertj.core)
    testImplementation(libs.detekt.test)
}
