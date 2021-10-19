plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("org.jetbrains.compose") version Dependency.COMPOSE_MULTIPLATFORM_VERSION
}

android {

    // Declaration admob id for release
    val releaseAdmobPublisherId = ""
    val releaseAdmobBanner = ""
    val releaseAdmobInterstitial = ""
    val releaseAdmobInterstitialVideo = ""
    val releaseAdmobRewarded = ""
    val releaseAdmobRewardedInterstitial = ""
    val releaseAdmobNativeAdvanced = ""
    val releaseAdmobNativeAdvancedVideo = ""

    compileSdk = ProjectSetting.PROJECT_COMPILE_SDK

    defaultConfig {
        applicationId = ProjectSetting.PROJECT_APP_ID
        minSdk = ProjectSetting.PROJECT_MIN_SDK
        targetSdk = ProjectSetting.PROJECT_TARGET_SDK
        versionCode = ProjectSetting.PROJECT_VERSION_CODE
        versionName = ProjectSetting.PROJECT_VERSION_NAME

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Naming APK // AAB
        setProperty("archivesBaseName", "${ProjectSetting.NAME_APK}(${versionName})")

        // Declaration build config
        buildConfigField("String", "DATABASE_NAME", ProjectSetting.DB)

        // Declaration apps name debug mode
        val debugAttribute = "Development"
        val nameAppDebug = "${ProjectSetting.NAME_APP} $debugAttribute"

        // Declaration admob id for debug
        val debugAdmobPublisherId = "ca-app-pub-3940256099942544~3347511713"
        val debugAdmobBanner = "ca-app-pub-3940256099942544/6300978111"
        val debugAdmobInterstitial = "ca-app-pub-3940256099942544/1033173712"
        val debugAdmobInterstitialVideo = "ca-app-pub-3940256099942544/8691691433"
        val debugAdmobRewarded = "ca-app-pub-3940256099942544/5224354917"
        val debugAdmobRewardedInterstitial = "ca-app-pub-3940256099942544/5354046379"
        val debugAdmobNativeAdvanced = "ca-app-pub-3940256099942544/2247696110"
        val debugAdmobNativeAdvancedVideo = "ca-app-pub-3940256099942544/1044960115"

        resConfigs("en", "id")

        // Inject app name for debug
        resValue("string", "app_name", nameAppDebug)

        // Inject admob id for debug
        resValue("string", "admob_publisher_id", debugAdmobPublisherId)
        resValue("string", "admob_banner", debugAdmobBanner)
        resValue("string", "admob_interstitial", debugAdmobInterstitial)
        resValue("string", "admob_interstitial_video", debugAdmobInterstitialVideo)
        resValue("string", "admob_rewarded", debugAdmobRewarded)
        resValue("string", "admob_rewarded_interstitial", debugAdmobRewardedInterstitial)
        resValue("string", "admob_native_advanced", debugAdmobNativeAdvanced)
        resValue("string", "admob_native_advanced_video", debugAdmobNativeAdvancedVideo)
    }

    signingConfigs {
        create("release") {
            // You need to specify either an absolute path or include the
            // keystore file in the same directory as the build.gradle file.
            // [PROJECT FOLDER NAME/app/[COPY YOUT KEY STORE] .jks in here
            storeFile = file("frogoboxdev.jks")
            storePassword = "cronoclez"
            keyAlias = "frogobox"
            keyPassword = "xeonranger"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            // Generated Signed APK / AAB
            signingConfig = signingConfigs.getByName("release")

            // Inject app name for release
            resValue("string", "app_name", ProjectSetting.APP_NAME)

            // Inject admob id for release
            resValue("string", "admob_publisher_id", releaseAdmobPublisherId)
            resValue("string", "admob_banner", releaseAdmobBanner)
            resValue("string", "admob_interstitial", releaseAdmobInterstitial)
            resValue("string", "admob_interstitial_video", releaseAdmobInterstitialVideo)
            resValue("string", "admob_rewarded", releaseAdmobRewarded)
            resValue("string", "admob_rewarded_interstitial", releaseAdmobRewardedInterstitial)
            resValue("string", "admob_native_advanced", releaseAdmobNativeAdvanced)
            resValue("string", "admob_native_advanced_video", releaseAdmobNativeAdvancedVideo)

        }
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
        useIR = true
    }

    packagingOptions {
        exclude("META-INF/*")
    }

}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Dependency.KOTLIN_VERSION}")

    implementation(compose.ui)
    implementation(compose.runtime)
    implementation(compose.material)
    implementation(compose.materialIconsExtended)

    implementation(project(":nutritioncore"))
    implementation(project(":nutritionframework"))

    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.preference:preference-ktx:1.1.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0-rc01")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")

    implementation("androidx.activity:activity-compose:1.3.1")
    implementation("androidx.activity:activity-ktx:${Dependency.ACTIVITY_KTX_VERSION}")
    implementation("androidx.fragment:fragment-ktx:${Dependency.FRAGMENT_KTX_VERSION}")

    implementation("androidx.room:room-runtime:2.3.0")
    implementation("androidx.room:room-ktx:2.3.0")
    implementation("androidx.room:room-rxjava2:2.3.0")
    implementation("androidx.room:room-guava:2.3.0")

    implementation("com.google.code.gson:gson:2.8.8")
    implementation("com.google.android.material:material:1.4.0")
    implementation("com.google.android.gms:play-services-ads:20.4.0")

    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")

    implementation("com.github.amirisback:frogo-recycler-view:3.8.8")
    implementation("com.github.amirisback:frogo-log:2.0.4")
    implementation("com.github.amirisback:frogo-admob:4.1.2")
    implementation("com.github.amirisback:frogo-ui-kit:2.1.0")
    implementation("com.github.amirisback:frogo-notification:1.0.7")
    implementation("com.github.amirisback:consumable-code-news-api:1.0.7")
    implementation("com.github.bumptech.glide:glide:4.12.0")

    implementation("com.facebook.stetho:stetho:1.5.1")
    implementation("com.readystatesoftware.chuck:library:1.1.0")

    api("com.google.dagger:dagger:2.38.1")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

    kapt("androidx.lifecycle:lifecycle-compiler:2.4.0-rc01")
    kapt("androidx.room:room-compiler:2.3.0")
    kapt("com.google.dagger:dagger-compiler:2.37")
    kapt("com.github.bumptech.glide:compiler:4.11.0")

    implementation("io.insert-koin:koin-core:${Dependency.KOIN_VERSION}") // Koin core features
    implementation("io.insert-koin:koin-android:${Dependency.KOIN_VERSION}") // Koin main features for Android (Scope,ViewModel ...)
    implementation("io.insert-koin:koin-android-compat:${Dependency.KOIN_VERSION}") // Koin Java Compatibility
    implementation("io.insert-koin:koin-androidx-workmanager:${Dependency.KOIN_VERSION}") // Koin for Jetpack WorkManager
    implementation("io.insert-koin:koin-androidx-compose:${Dependency.KOIN_VERSION}") // Koin for Jetpack Compose

    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.room:room-testing:2.3.0")
    testImplementation("io.insert-koin:koin-test:${Dependency.KOIN_VERSION}")

    androidTestImplementation("androidx.room:room-testing:2.3.0")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    debugImplementation(compose.ui)

}