import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack

//buildscript {
//    ext {
//        // TODO: upgrade once bug is fixed:
//        //  https://github.com/spring-projects/spring-framework/issues/23961
////        springBootVersion = '2.2.0.RELEASE'
//        springBootVersion = '2.2.6.RELEASE'
//    }
//    repositories {
//        mavenCentral()
//    }
//    dependencies {
//        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
//        classpath("org.jetbrains.kotlin:kotlin-allopen:${kotlinVersion}")
//    }
//}


plugins {
//    id 'java'
//    id 'org.jetbrains.kotlin.jvm'
//    id 'kotlinx-serialization'

    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") //version "1.3.71"
    kotlin("plugin.spring") version "1.3.71"
}

//apply plugin: 'kotlin-spring'
//apply plugin: 'org.springframework.boot'
//apply plugin: 'io.spring.dependency-management'


repositories {
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    jcenter()
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-js-wrappers") }
    maven { setUrl("https://dl.bintray.com/kotlin/kotlinx") }
    mavenCentral()
}

val kotlin_version = "pre.94-kotlin-1.3.70" // for kotlin-wrappers
val logback_version = "1.2.3"
val kotlinx_serialization_version = "0.20.0"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.jetbrains:kotlin-css-jvm:1.0.0-$kotlin_version")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:$kotlinx_serialization_version")

    implementation(project(":proj-common"))

    implementation("org.springframework.boot:spring-boot-starter-webflux")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

tasks.withType<ProcessResources> {
    val jsProject = project(":proj-js")
    val task = jsProject.tasks.getByName("browserProductionWebpack") as KotlinWebpack

    from(task.destinationDirectory!!) {
        into("public")
    }

    dependsOn(project(":proj-js").tasks.getByName("browserProductionWebpack"))
}


////// Dev server
//task devServer(type: JavaExec) {
//    dependsOn "compileKotlin"
//
//    classpath = project.files(
//            configurations.runtimeClasspath,
//            new File(project.buildDir, "classes/kotlin/main"),
//            new File(project.buildDir, "dev-resources")
//    )
//}
///////////////


tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

//compileKotlin {
//    targetCompatibility = javaVersion
//    sourceCompatibility = javaVersion
//    kotlinOptions {
//        freeCompilerArgs = ["-Xjsr305=strict"]
//        jvmTarget = javaVersion
//    }
//}
//compileTestKotlin {
//    kotlinOptions {
//        freeCompilerArgs = ["-Xjsr305=strict"]
//        jvmTarget = javaVersion
//    }
//}


//jar {
//    enabled = true
//}
//bootJar {
//    classifier = 'boot'
//}
tasks.getByName<Jar>("jar") {
    enabled = true
}

tasks.getByName<BootJar>("bootJar") {
//    classifier = "boot"
    archiveClassifier.set("boot")
}

