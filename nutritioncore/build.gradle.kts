import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm")
    id("org.jetbrains.compose") version DependencyGradle.COMPOSE_MULTIPLATFORM_VERSION
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

    api(compose.ui)
    api(compose.runtime)
    api(compose.preview)
    api(compose.uiTooling)
    api(compose.material)
    api(compose.materialIconsExtended)

    api(Square.OkHttp.okhttp)
    api(Square.OkHttp.loggingInterceptor)

    api(Square.Retrofit2.retrofit)
    api(Square.Retrofit2.converterGson)
    api(Square.Retrofit2.adapterRxJava3)

    api(Google.gson)
    api(Koin.core)

    api(Reactivex.rxJava3)

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
            artifactId = ProjectSetting.PACKAGE_NAME_LIBRARY_CORE

            // Version Library Name (Example : "1.0.0")
            version = ProjectSetting.PROJECT_VERSION_NAME

        }

    }

    repositories {
        maven("https://jitpack.io")
    }

}