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

    implementation(project(":nutritioncore"))
    implementation(project(":nutritionframework"))

    implementation(compose.ui)
    implementation(compose.runtime)
    implementation(compose.preview)
    implementation(compose.uiTooling)
    implementation(compose.material)
    implementation(compose.materialIconsExtended)

    implementation(Androidx.appCompat)
    implementation(Androidx.constraintLayout)
    implementation(Androidx.Compose.activity)

    implementation(Androidx.activityKtx)
    implementation(Androidx.fragmentKtx)
    implementation(Androidx.Core.ktx)
    implementation(Androidx.preferenceKtx)
    implementation(Androidx.Lifecycle.livedataKtx)
    implementation(Androidx.Lifecycle.viewmodelKtx)
    implementation(Androidx.Lifecycle.runtimeKtx)
    implementation(Androidx.Lifecycle.reactivestreamsKtx)

    implementation(Androidx.navigationFragmentKtx)
    implementation(Androidx.navigationRuntimeKtx)
    implementation(Androidx.navigationUiKtx)

    implementation(Androidx.collection)

    implementation(Androidx.Room.runtime)
    implementation(Androidx.Room.ktx)
    implementation(Androidx.Room.rxJava3)

    implementation(Google.admob)
    implementation(Google.gson)
    implementation(Google.material)

    implementation(Square.okhttp)
    implementation(Square.okhttpLogging)

    implementation(Square.Retrofit2.retrofit)
    implementation(Square.Retrofit2.converterGson)
    implementation(Square.Retrofit2.adapterRxJava3)

    implementation(Reactivex.rxAndroid3)
    implementation(Reactivex.rxJava3)

    implementation(Koin.core)
    implementation(Koin.android)
    implementation(Koin.androidCompat)
    implementation(Koin.androidxWorkManager)
    implementation(Koin.androidxCompose)

    implementation(Util.glide)

    implementation(Util.hdodenhofCircleImageView)
    implementation(Util.chucker)

    implementation("io.coil-kt:coil-compose:1.4.0")

    api(JetBrains.coroutinesCore)
    api(JetBrains.coroutinesAndroid)

    kapt(Androidx.Lifecycle.compiler)
    kapt(Androidx.Room.compiler)
    kapt(Util.glideCompiler)

    debugImplementation(compose.ui)
    debugImplementation(compose.uiTooling)

}