import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    kotlin("multiplatform")
    id("com.google.devtools.ksp") version Deps.Ksp.version
    id("org.jetbrains.kotlin.plugin.serialization") version Deps.kotlinVersion
}

group = "io.peekandpoke.kraft.examples"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
//    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
//
    mavenLocal()
}

kotlin {
    js(IR) {
        browser {
            binaries.executable()

            // Add webpack configuration
            commonWebpackConfig {
                devServer = (devServer ?: KotlinWebpackConfig.DevServer()).copy(
                    port = 55001
                )
            }
        }
    }

    jvmToolchain(17)

    jvm {
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(Deps.KotlinLibs.Mutator.core)
            }
        }

        jsMain {
            dependencies {
                implementation(Deps.KotlinLibs.Kraft.semanticui)
            }
        }
    }
}

dependencies {
    add("kspJs", Deps.KotlinLibs.Mutator.ksp)
}

tasks {
    named("compileKotlinJs") {
        dependsOn("kspKotlinJs")
    }
}
