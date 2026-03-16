@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl


plugins {
    kotlin("multiplatform")
    kotlin("plugin.compose")
    id("org.jetbrains.compose")
}

val kotlinxBrowserVersion = project.extra["kotlinx.browser.version"] as String

kotlin {
    wasmJs {
        browser()
        binaries.executable()
    }

// Make sure the correct version of Lets-Plot JS is set in ./resources/index.html
//    val letsPlotVersion = project.property("letsPlot.version") as String

    val letsPlotKotlinVersion = project.property("letsPlotKotlin.version") as String

    sourceSets {
        wasmJsMain {
            dependencies {
                implementation(compose.html.core)
                implementation(compose.runtime)

                implementation("org.jetbrains.lets-plot:lets-plot-kotlin:$letsPlotKotlinVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-browser:${kotlinxBrowserVersion}")
            }
        }
    }
}
