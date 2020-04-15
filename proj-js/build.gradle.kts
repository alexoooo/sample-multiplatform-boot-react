plugins {
    id("org.jetbrains.kotlin.js")
}


kotlin {
    target {
        useCommonJs()
        browser {
            // TODO: figure out keep("io.github.alexoooo.sample.**") pattern
            dceTask {
                // https://stackoverflow.com/questions/60581223/dcetask-keep-is-not-preserving-defined-classes
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
    implementation("org.jetbrains.kotlinx:kotlinx-html:0.6.12")
    implementation("org.jetbrains:kotlin-react:16.13.0-$wrapperKotlinVersion")
    implementation("org.jetbrains:kotlin-react-dom:16.13.0-$wrapperKotlinVersion")
    implementation("org.jetbrains:kotlin-styled:1.0.0-$wrapperKotlinVersion")
    implementation("org.jetbrains:kotlin-extensions:1.0.1-$wrapperKotlinVersion")
    implementation("org.jetbrains:kotlin-css-js:1.0.0-$wrapperKotlinVersion")
    implementation(npm("react", reactVersion))
    implementation(npm("react-dom", reactVersion))
    implementation(npm("react-is", reactVersion))
    implementation(npm("inline-style-prefixer", "5.1.0"))
    implementation(npm("styled-components", "4.3.2"))
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