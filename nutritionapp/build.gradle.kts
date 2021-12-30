plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("org.jetbrains.compose") version DependencyGradle.COMPOSE_MULTIPLATFORM_VERSION
}

android {

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

        // Inject app name for debug
        resValue("string", "app_name", ProjectSetting.nameAppDebug)

        // Inject admob id for debug
        resValue("string", "admob_publisher_id", AdmobID.debugAdmobPublisherId)
        resValue("string", "admob_banner", AdmobID.debugAdmobBanner)
        resValue("string", "admob_interstitial", AdmobID.debugAdmobInterstitial)
        resValue("string", "admob_interstitial_video", AdmobID.debugAdmobInterstitialVideo)
        resValue("string", "admob_rewarded", AdmobID.debugAdmobRewarded)
        resValue("string", "admob_rewarded_interstitial", AdmobID.debugAdmobRewardedInterstitial)
        resValue("string", "admob_native_advanced", AdmobID.debugAdmobNativeAdvanced)
        resValue("string", "admob_native_advanced_video", AdmobID.debugAdmobNativeAdvancedVideo)
    }

    signingConfigs {
        create("release") {
            // You need to specify either an absolute path or include the
            // keystore file in the same directory as the build.gradle file.
            // [PROJECT FOLDER NAME/app/[COPY YOUT KEY STORE] .jks in here
            storeFile = file(ProjectSetting.PLAYSTORE_STORE_FILE)
            storePassword = ProjectSetting.PLAYSTORE_STORE_PASSWORD
            keyAlias = ProjectSetting.PLAYSTORE_KEY_ALIAS
            keyPassword = ProjectSetting.PLAYSTORE_KEY_PASSWORD
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
            resValue("string", "app_name", ProjectSetting.NAME_APP)

            // Inject admob id for release
            resValue("string", "admob_publisher_id", AdmobID.releaseAdmobPublisherId)
            resValue("string", "admob_banner", AdmobID.releaseAdmobBanner)
            resValue("string", "admob_interstitial", AdmobID.releaseAdmobInterstitial)
            resValue("string", "admob_interstitial_video", AdmobID.releaseAdmobInterstitialVideo)
            resValue("string", "admob_rewarded", AdmobID.releaseAdmobRewarded)
            resValue("string", "admob_rewarded_interstitial", AdmobID.releaseAdmobRewardedInterstitial)
            resValue("string", "admob_native_advanced", AdmobID.releaseAdmobNativeAdvanced)
            resValue("string", "admob_native_advanced_video", AdmobID.releaseAdmobNativeAdvancedVideo)

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
    }

}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${DependencyGradle.KOTLIN_VERSION}")

    implementation(compose.ui)
    implementation(compose.runtime)
    implementation(compose.preview)
    implementation(compose.uiTooling)
    implementation(compose.material)
    implementation(compose.materialIconsExtended)

    implementation(project(":nutritioncore"))
    implementation(project(":nutritionframework"))

    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation("androidx.activity:activity-compose:1.4.0")

    implementation("androidx.activity:activity-ktx:${DependencyGradle.ACTIVITY_KTX_VERSION}")
    implementation("androidx.fragment:fragment-ktx:${DependencyGradle.FRAGMENT_KTX_VERSION}")
    
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.preference:preference-ktx:1.1.1")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata-core-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")

    implementation("androidx.navigation:navigation-runtime-ktx:2.3.5")
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")

    implementation("androidx.collection:collection-ktx:1.2.0")

    implementation("androidx.paging:paging-common-ktx:3.1.0")
    implementation("androidx.paging:paging-runtime-ktx:3.1.0")
    implementation("androidx.paging:paging-rxjava2-ktx:3.1.0")
    
    implementation("androidx.room:room-runtime:${DependencyGradle.ROOM_VERSION}")
    implementation("androidx.room:room-ktx:${DependencyGradle.ROOM_VERSION}")
    implementation("androidx.room:room-rxjava2:${DependencyGradle.ROOM_VERSION}")
    implementation("androidx.room:room-guava:${DependencyGradle.ROOM_VERSION}")

    implementation("com.google.code.gson:gson:${DependencyGradle.GSON_VERSION}")
    implementation("com.google.android.material:material:1.4.0")
    implementation("com.google.android.play:core-ktx:1.8.1")
    implementation("com.google.android.gms:play-services-ads:20.5.0")

    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    implementation("com.squareup.retrofit2:retrofit:${DependencyGradle.RETROFIT_VERSION}")
    implementation("com.squareup.retrofit2:converter-gson:${DependencyGradle.RETROFIT_VERSION}")
    implementation("com.squareup.retrofit2:adapter-rxjava:${DependencyGradle.RETROFIT_VERSION}")
    implementation("com.squareup.retrofit2:adapter-rxjava2:${DependencyGradle.RETROFIT_VERSION}")

    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")

    implementation("com.github.bumptech.glide:glide:4.12.0")

    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation("com.facebook.stetho:stetho:1.5.1")
    implementation("com.readystatesoftware.chuck:library:1.1.0")

    api("com.google.dagger:dagger:2.38.1")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:${DependencyGradle.COROUTINES_VERSION}")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:${DependencyGradle.COROUTINES_VERSION}")

    kapt("androidx.lifecycle:lifecycle-compiler:2.4.0")
    kapt("androidx.room:room-compiler:${DependencyGradle.ROOM_VERSION}")
    kapt("com.google.dagger:dagger-compiler:2.37")
    kapt("com.github.bumptech.glide:compiler:4.12.0")

    implementation("io.coil-kt:coil-compose:1.4.0")
    implementation("io.insert-koin:koin-core:${DependencyGradle.KOIN_VERSION}") // Koin core features
    implementation("io.insert-koin:koin-android:${DependencyGradle.KOIN_VERSION}") // Koin main features for Android (Scope,ViewModel ...)
    implementation("io.insert-koin:koin-android-compat:${DependencyGradle.KOIN_VERSION}") // Koin Java Compatibility
    implementation("io.insert-koin:koin-androidx-workmanager:${DependencyGradle.KOIN_VERSION}") // Koin for Jetpack WorkManager
    implementation("io.insert-koin:koin-androidx-compose:${DependencyGradle.KOIN_VERSION}") // Koin for Jetpack Compose

    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.room:room-testing:${DependencyGradle.ROOM_VERSION}")
    testImplementation("io.insert-koin:koin-test:${DependencyGradle.KOIN_VERSION}")

    androidTestImplementation("androidx.room:room-testing:${DependencyGradle.ROOM_VERSION}")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    debugImplementation(compose.ui)
    debugImplementation(compose.uiTooling)

}