plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization") version KOTLIN_VERSION
    id("com.github.gmazzo.buildconfig") version "3.0.3"
}

buildConfig {
    className("BuildConfig")
    packageName("conf")
    buildConfigField("String", "BUILD_TIME", """ "$BUILD_TIME_STR" """)
}

kotlin {
    js(IR) {
        useCommonJs()
        browser {}
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$SERIALIZATION_VERSION")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$SERIALIZATION_VERSION")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_VERSION")
            }
        }
        val jsMain by getting {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.runtime)
            }
        }
    }
}
