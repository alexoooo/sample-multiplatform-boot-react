plugins {
    kotlin("multiplatform") version kotlinVersion apply false
    kotlin("plugin.serialization") version kotlinVersion apply false
}

allprojects {
    version = "0.2.0-SNAPSHOT"

    repositories {
        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
        jcenter()
        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
        maven { setUrl("https://dl.bintray.com/kotlin/kotlinx") }
        mavenCentral()

        maven { setUrl("https://raw.githubusercontent.com/alexoooo/kzen-repo/master/artifacts") }
    }
}
