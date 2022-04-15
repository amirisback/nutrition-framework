plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("org.jetbrains.compose") version DependencyGradle.COMPOSE_MULTIPLATFORM_VERSION
    `maven-publish`
}

android {

    compileSdk = ProjectSetting.PROJECT_COMPILE_SDK

    defaultConfig {
        minSdk = ProjectSetting.PROJECT_MIN_SDK
        targetSdk = ProjectSetting.PROJECT_TARGET_SDK

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        consumerProguardFile("consumer-rules.pro")
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

}

dependencies {

    api(project(":nutritioncore"))

    api(compose.ui)
    api(compose.runtime)
    api(compose.preview)
    api(compose.uiTooling)
    api(compose.material)
    api(compose.materialIconsExtended)

    api(Androidx.appCompat)
    api(Androidx.constraintLayout)
    api(Androidx.Core.ktx)
    api(Androidx.Lifecycle.livedataKtx)
    api(Androidx.Lifecycle.viewmodelKtx)
    api(Androidx.Lifecycle.runtimeKtx)

    api(Google.admob)
    api(Google.gson)
    api(Google.material)

    api(Square.OkHttp.okhttp)
    api(Square.OkHttp.loggingInterceptor)

    api(Square.Retrofit2.retrofit)
    api(Square.Retrofit2.converterGson)
    api(Square.Retrofit2.adapterRxJava3)

    api(Reactivex.rxAndroid3)
    api(Reactivex.rxJava3)

    api(GitHub.glide)
    api(GitHub.chucker)

    api(Util.hdodenhofCircleImageView)

    api("io.coil-kt:coil-compose:1.4.0")
    api("com.github.javiersantos:PiracyChecker:1.2.8")
    api("com.facebook.shimmer:shimmer:0.5.0")

    api(JetBrains.coroutinesCore)
    api(JetBrains.coroutinesAndroid)

    kapt(Androidx.Lifecycle.compiler)
    kapt(GitHub.glideCompiler)

    debugImplementation(compose.ui)
    debugImplementation(compose.uiTooling)

}

afterEvaluate {
    publishing {
        publications {

            // Creates a Maven publication called "release".
            register("release", MavenPublication::class) {

                // Applies the component for the release build variant.
                // NOTE : Delete this line code if you publish Native Java / Kotlin Library
                from(components["release"])

                // Library Package Name (Example : "com.frogobox.androidfirstlib")
                // NOTE : Different GroupId For Each Library / Module, So That Each Library Is Not Overwritten
                groupId = ProjectSetting.PROJECT_LIB_ID_FRAMEWORK

                // Library Name / Module Name (Example : "androidfirstlib")
                // NOTE : Different ArtifactId For Each Library / Module, So That Each Library Is Not Overwritten
                artifactId = ProjectSetting.PACKAGE_NAME_LIBRARY_FRAMEWORK

                // Version Library Name (Example : "1.0.0")
                version = ProjectSetting.PROJECT_VERSION_NAME

            }
        }
    }
}