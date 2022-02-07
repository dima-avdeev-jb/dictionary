pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}
rootProject.name = "dictionary"

include("client")
include("lib")
//include("network")
