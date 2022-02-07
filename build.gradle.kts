plugins {
    id("org.jetbrains.kotlin.multiplatform") version KOTLIN_VERSION apply false
    id("org.jetbrains.compose") version "1.0.1" apply false
}

allprojects {
    version = "1.0"
    repositories {
        mavenCentral()
    }
}
