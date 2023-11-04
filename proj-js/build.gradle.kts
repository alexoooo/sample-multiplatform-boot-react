import org.jetbrains.kotlin.gradle.targets.js.yarn.yarn

plugins {
    kotlin("multiplatform")
}


kotlin {
    js {
        useCommonJs()
        binaries.executable()

        browser {
            webpackTask {}
        }
    }

    sourceSets {
        jsMain {
            dependencies {
                implementation(project(":proj-common"))

                implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:$kotlinEmotionVersion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react:$kotlinReactVersion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:$kotlinReactDomVersion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui:$kotlinMuiVersion")

                implementation("io.github.alexoooo.sample.lib:lib-common-js:$libVersion")
                implementation("io.github.alexoooo.sample.lib:lib-js:$libVersion")
            }
        }

        jsTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}


run {}


// https://youtrack.jetbrains.com/issue/KT-52578/KJS-Gradle-KotlinNpmInstallTask-gradle-task-produces-unsolvable-warning-ignored-scripts-due-to-flag.
yarn.ignoreScripts = false