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

    api(project(":nutritioncore"))
    api(project(":nutritionframework"))

    api(compose.ui)
    api(compose.runtime)
    api(compose.preview)
    api(compose.uiTooling)
    api(compose.material)
    api(compose.materialIconsExtended)

    api(Androidx.appCompat)
    api(Androidx.constraintLayout)
    api(Androidx.Compose.activity)

    api(Androidx.activityKtx)
    api(Androidx.fragmentKtx)
    api(Androidx.Core.ktx)
    api(Androidx.preferenceKtx)
    api(Androidx.Lifecycle.livedataKtx)
    api(Androidx.Lifecycle.viewmodelKtx)
    api(Androidx.Lifecycle.runtimeKtx)
    api(Androidx.Lifecycle.reactivestreamsKtx)

    api(Androidx.navigationFragmentKtx)
    api(Androidx.navigationRuntimeKtx)
    api(Androidx.navigationUiKtx)

    api(Androidx.collection)

    api(Androidx.Room.runtime)
    api(Androidx.Room.ktx)
    api(Androidx.Room.rxJava3)

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

    api(Koin.core)
    api(Koin.android)
    api(Koin.androidCompat)
    api(Koin.androidxWorkManager)
    api(Koin.androidxCompose)

    api(GitHub.glide)
    api(GitHub.chucker)
    
    api(Util.hdodenhofCircleImageView)
    
    api("io.coil-kt:coil-compose:1.4.0")

    api(JetBrains.coroutinesCore)
    api(JetBrains.coroutinesAndroid)

    kapt(Androidx.Lifecycle.compiler)
    kapt(Androidx.Room.compiler)
    kapt(GitHub.glideCompiler)

    debugImplementation(compose.ui)
    debugImplementation(compose.uiTooling)

}