pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    plugins {
        val kotlinVersion = extra["kotlin.version"] as String
        val jfxPluginVersion = extra["jfxPlugin.version"] as String
        val composeVersion = extra["compose.version"] as String

        kotlin("multiplatform") version kotlinVersion
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.compose").version(kotlinVersion)
        id("org.jetbrains.compose").version(composeVersion)
        id("org.openjfx.javafxplugin") version jfxPluginVersion
    }
}

include("js-frontend-app")
include("jvm-swing-batik-app")
include("jvm-swing-app")
include("jvm-javafx-app")
include("jvm-plot-export")
include("wasmjs-frontend-app")
