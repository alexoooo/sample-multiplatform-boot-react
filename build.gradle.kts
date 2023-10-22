plugins {
    kotlin("multiplatform") version kotlinVersion apply false
    kotlin("plugin.serialization") version kotlinVersion apply false
}

allprojects {
    group = "io.github.alexoooo.sample.proj"
    version = "0.5.0-SNAPSHOT"

    repositories {
        mavenLocal()
        mavenCentral()

        maven { setUrl("https://raw.githubusercontent.com/alexoooo/kzen-repo/master/artifacts") }
    }
}
