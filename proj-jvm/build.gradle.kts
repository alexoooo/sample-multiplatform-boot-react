@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar


plugins {
    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version dependencyManagementVersion
    kotlin("jvm")
    kotlin("plugin.spring") version kotlinVersion
}


kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(jvmToolchainVersion))
    }
}


dependencies {
    implementation(project(":proj-common"))

//    implementation("io.github.microutils:kotlin-logging:$kotlinLogging")
//    implementation("ch.qos.logback:logback-classic:$logbackVersion")

//    implementation("org.jetbrains.kotlin-wrappers:kotlin-css-jvm:1.0.0-$wrapperKotlinVersion")
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$serializationVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")

    implementation("org.springframework.boot:spring-boot-starter-webflux")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    implementation("io.github.alexoooo.sample.lib:lib-common-jvm:$libVersion")
    implementation("io.github.alexoooo.sample.lib:lib-jvm:$libVersion")

    implementation("com.github.andrewoma.dexx:collection:$dexxVersion")
}


tasks.withType<ProcessResources> {
    val jsProject = project(":proj-js")

    val browserDistributionTask = jsProject.tasks.getByName("jsBrowserDistribution")
    dependsOn(browserDistributionTask)

    val task = jsProject.tasks.getByName("jsBrowserProductionWebpack") as KotlinWebpack
    dependsOn(task)

    from(task.outputDirectory) {
        into("public")
    }
}


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = jvmTargetVersion
    }
}

tasks.compileJava {
    options.release.set(javaVersion)
}

tasks.getByName<Jar>("jar") {
    enabled = true
}

tasks.getByName<BootJar>("bootJar") {
    archiveClassifier.set("boot")
}

