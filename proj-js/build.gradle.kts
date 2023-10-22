plugins {
    kotlin("multiplatform")
}


kotlin {
    js {
        useCommonJs()
        binaries.executable()

        browser {
            webpackTask(Action {

            })
        }
    }

    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project(":proj-common"))

                implementation("org.jetbrains.kotlinx:kotlinx-html-assembly:$kotlinxHtmlAssemblyVersion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react:$kotlinReactVersion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:$kotlinReactDomVersion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:$kotlinEmotionVersion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui:$kotlinMuiVersion")

//    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:$kotlinReactVersion")
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-legacy:$kotlinReactVersion")
//    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:$kotlinReactDomVersion")
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom-legacy:$kotlinReactDomVersion")

//                implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:$kotlinStyledVersion")
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-extensions:$kotlinExtensionsVersion")
//                implementation("org.jetbrains.kotlin-wrappers:kotlin-css-js:$kotlinCssVersion")
//                implementation(npm("react", reactVersion))
//                implementation(npm("react-dom", reactVersion))
//                implementation(npm("react-is", reactVersion))
//                implementation(npm("inline-style-prefixer", inlineStylePrefixerVersion))
//                implementation(npm("styled-components", styledComponentsVersion))

//                implementation(npm("@mui/material", muiMaterialVersion))
//                implementation(npm("@mui/icons-material", muiIconsVersion))
//                implementation(npm("@mui/styles", muiStylesVersion))
//                implementation(npm("@emotion/styled", emotionStyledVersion))
//                implementation(npm("@emotion/react", emotionReactVersion))

                implementation("io.github.alexoooo.sample.lib:lib-common-js:$libVersion")
                implementation("io.github.alexoooo.sample.lib:lib-js:$libVersion")
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}


//configurations.implementation {
////    exclude(group = "org.jetbrains.kotlin-wrappers", module = "kotlin-react-legacy")
////    exclude(group = "org.jetbrains.kotlin-wrappers", module = "kotlin-react-dom-legacy")
//    exclude(group = "org.jetbrains.kotlin-wrappers", module = "kotlin-react-dom")
//}
//
//
//// https://youtrack.jetbrains.com/issue/KT-49124
////rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
////    versions.webpackCli.version = "4.9.0"
////}
//rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin> {
//    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension>().apply {
//        resolution("@webpack-cli/serve", "1.6.1")
//    }
//}


run {
//    project(":proj-jvm").afterEvaluate {
//        dependsOn project(":proj-jvm").tasks.getByName('prepareDevServer')
//    }
}


//tasks.getByName("processDceKotlinJs") {
//    enabled = false
//}
