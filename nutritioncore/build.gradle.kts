import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm")
    id("org.jetbrains.compose") version Dependency.COMPOSE_MULTIPLATFORM_VERSION
    `maven-publish`
}

group = ProjectSetting.PROJECT_LIB_ID_CORE
version = ProjectSetting.PROJECT_VERSION_NAME

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
}

dependencies {

    implementation(compose.ui)
    implementation(compose.runtime)
    implementation(compose.preview)
    implementation(compose.uiTooling)
    implementation(compose.material)
    implementation(compose.materialIconsExtended)

    implementation("com.google.code.gson:gson:2.8.9")

    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    implementation("io.insert-koin:koin-core:${Dependency.KOIN_VERSION}") // Koin core features

    implementation("io.reactivex.rxjava2:rxjava:2.2.21")
}

publishing {

    publications {

        // Creates a Maven publication called "release".
        register("release", MavenPublication::class) {

            from(components["java"])

            // Library Package Name (Example : "com.frogobox.androidfirstlib")
            // NOTE : Different GroupId For Each Library / Module, So That Each Library Is Not Overwritten
            groupId = ProjectSetting.PROJECT_LIB_ID_CORE

            // Library Name / Module Name (Example : "androidfirstlib")
            // NOTE : Different ArtifactId For Each Library / Module, So That Each Library Is Not Overwritten
            artifactId = ProjectSetting.LIBRARY_NAME_CORE

            // Version Library Name (Example : "1.0.0")
            version = ProjectSetting.PROJECT_VERSION_NAME

        }

    }

    repositories {
        maven { url = uri("https://jitpack.io") }
    }

}