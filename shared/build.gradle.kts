import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jmailen.gradle.kotlinter.tasks.FormatTask
import org.jmailen.gradle.kotlinter.tasks.LintTask
import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.apollo.graphql)
    alias(libs.plugins.buildKonfig)
    alias(libs.plugins.cash.burst)
    alias(libs.plugins.cash.sqldelight)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = false
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.androidx.navigation.compose)
            implementation(libs.apollo.runtime)
            implementation(libs.cash.sqldelight.coroutines)
            implementation(libs.cash.sqldelight.runtime)
            implementation(libs.coil.compose)
            implementation(libs.coil.ktor)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.koin.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.material.kolor)
            implementation(libs.material3.window.size.class1)
        }

        androidMain.dependencies {
            implementation(libs.androidx.xr.compose)
            implementation(libs.androidx.xr.compose.material3)
            implementation(libs.androidx.xr.scenecore)
            implementation(libs.cash.sqldelight.android.driver)
            implementation(libs.ktor.client.android)
        }

        iosMain.dependencies {
            implementation(libs.cash.sqldelight.native.driver)
            implementation(libs.ktor.client.darwin)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.koin.test)
            implementation(libs.ktor.client.testing)
            implementation(libs.varabyte.truthish)
        }
    }
}

compose.resources {
    publicResClass = false
    packageOfResClass = "com.adammcneilly.pwhl.mobile.shared"
    generateResClass = auto
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    namespace = "com.adammcneilly.pwhl.mobile.shared"
}

sqldelight {
    databases {
        create("AppDatabase") {
            packageName.set("com.adammcneilly.pwhl.mobile.shared")
        }
    }
}

// NOTE: Replace the template schema.json with the schema for your apollo api.
apollo {
    service("service") {
        packageName.set("com.adammcneilly.pwhl.mobile.shared")
    }
}

buildkonfig {
    packageName = "com.adammcneilly.pwhl.mobile.shared"

    val properties = Properties()
    properties.load(FileInputStream(project.rootProject.file("local.properties")))

    defaultConfigs {
        buildConfigField(STRING, "PWHL_API_KEY", properties["PWHL_API_KEY"].toString())
    }
}

tasks.withType<FormatTask> {
    exclude { it.file.path.contains("build/")}
}

tasks.withType<LintTask> {
    exclude { it.file.path.contains("build/")}
}
