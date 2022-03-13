plugins {
    id("org.jetbrains.kotlin.js")
}


kotlin {
//    target {
    js {
        useCommonJs()

//        produceExecutable()

        browser {
            webpackTask {

            }
        }
    }
}


dependencies {
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:$serializationVersion")

    implementation(project(":proj-common"))

//    implementation(npm("core-js", coreJsVersion))
//    implementation("org.jetbrains.kotlinx:kotlinx-html-assembly:$kotlinxHtmlVersion")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:$kotlinReactVersion")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:$kotlinReactDomVersion")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-styled:$kotlinStyledVersion")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-extensions:$kotlinExtensionsVersion")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-css-js:$kotlinCssVersion")
    implementation(npm("react", reactVersion))
    implementation(npm("react-dom", reactVersion))
    implementation(npm("react-is", reactVersion))
    implementation(npm("inline-style-prefixer", inlineStylePrefixerVersion))
    implementation(npm("styled-components", styledComponentsVersion))
    testImplementation("org.jetbrains.kotlin:kotlin-test-js")
//    testImplementation(npm("enzyme", "3.11.0"))
//    testImplementation(npm("enzyme-adapter-react-16", "1.12.1"))

    implementation("io.github.alexoooo.sample.lib:lib-common-js:$libVersion")
    implementation("io.github.alexoooo.sample.lib:lib-js:$libVersion")
}


// https://youtrack.jetbrains.com/issue/KT-49124
//rootProject.extensions.configure<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension> {
//    versions.webpackCli.version = "4.9.0"
//}
rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnPlugin> {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.yarn.YarnRootExtension>().apply {
        resolution("@webpack-cli/serve", "1.6.1")
    }
}


run {
//    project(":proj-jvm").afterEvaluate {
//        dependsOn project(":proj-jvm").tasks.getByName('prepareDevServer')
//    }
}


//tasks.getByName("processDceKotlinJs") {
//    enabled = false
//}
