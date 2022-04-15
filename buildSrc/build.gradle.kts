import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    // library open-build-src
    implementation("com.github.frogobox:open-build-src:1.1.1")
}