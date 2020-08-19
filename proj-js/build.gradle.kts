plugins {
    id("org.jetbrains.kotlin.js")
}


kotlin {
    target {
        useCommonJs()

//        produceExecutable()

        browser {
            // TODO: figure out keep("io.github.alexoooo.sample.**") pattern
            dceTask {
                // https://stackoverflow.com/questions/60581223/dcetask-keep-is-not-preserving-defined-classes
                // https://kotlinlang.org/docs/reference/javascript-dce.html
                // https://github.com/JetBrains/kotlin/blob/ce2ae58ffb1e9a4e54c4b4aa8ec29298a1113be1/libraries/tools/kotlin-gradle-plugin/src/main/kotlin/org/jetbrains/kotlin/gradle/tasks/KotlinJsDce.kt
//                keep("lib-lib-js.io.github.alexoooo.sample.lib.model.CommonModel")
//                keep("proj-js.io.github.alexoooo.sample.proj.model.ProjJsTestModel")
//                keep("proj-proj-js.io.github.alexoooo.sample.proj.model.ProjJsTestModel")
//                keep("proj-js.js_io.github.alexoooo.sample.proj.model.ProjJsTestModel")
                dceOptions {
                    devMode = true
                }
            }
        }
    }
}


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:$serializationVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:$coroutinesVersion")

    implementation(project(":proj-common"))

    implementation(npm("core-js", coreJsVersion))
    implementation("org.jetbrains.kotlinx:kotlinx-html-assembly:$kotlinxHtmlVersion")
    implementation("org.jetbrains:kotlin-react:$kotlinxReactVersion")
    implementation("org.jetbrains:kotlin-react-dom:$kotlinxReactDomVersion")
    implementation("org.jetbrains:kotlin-styled:$kotlinxStyledVersion")
    implementation("org.jetbrains:kotlin-extensions:$kotlinxExtensionsVersion")
    implementation("org.jetbrains:kotlin-css-js:$kotlinxCssVersion")
    implementation(npm("react", reactVersion))
    implementation(npm("react-dom", reactVersion))
    implementation(npm("react-is", reactVersion))
    implementation(npm("inline-style-prefixer", inlineStylePrefixerVersion))
    implementation(npm("styled-components", styledComponentsVersion))
    testImplementation("org.jetbrains.kotlin:kotlin-test-js")
    testImplementation(npm("enzyme", "3.9.0"))
    testImplementation(npm("enzyme-adapter-react-16", "1.12.1"))

    implementation("io.github.alexoooo.sample.lib:lib-common-js:$libVersion")
    implementation("io.github.alexoooo.sample.lib:lib-js:$libVersion")
}

run {
//    project(":proj-jvm").afterEvaluate {
//        dependsOn project(":proj-jvm").tasks.getByName('prepareDevServer')
//    }
}


//tasks.getByName("processDceKotlinJs") {
//    enabled = false
//}
