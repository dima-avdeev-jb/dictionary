plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization") version KOTLIN_VERSION
}

kotlin {
    js(IR) {
        browser() {
            binaries.executable()
        }
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)

                implementation(project(":lib"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_VERSION")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$SERIALIZATION_VERSION")
                implementation(npm("colors", "=1.4.0"))//temp vulnerability fix, use strict version 1.4.0
            }
        }
    }
}

// a temporary workaround for a bug in jsRun invocation - see https://youtrack.jetbrains.com/issue/KT-48273
afterEvaluate {
    rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
        versions.webpackDevServer.version = "4.0.0"
        versions.webpackCli.version = "4.9.0"
    }
}
