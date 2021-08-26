pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlinx-serialization") {
                useModule("org.jetbrains.kotlin:kotlin-serialization:${requested.version}")
            }
        }
    }

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "proj"

include("proj-common", "proj-js", "proj-jvm")