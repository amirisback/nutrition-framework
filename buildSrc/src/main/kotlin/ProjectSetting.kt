/*
 * Created by faisalamir on 19/09/21
 * NutriRecyclerView
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2021 FrogoBox Inc.
 * All rights reserved
 *
 */

object ProjectSetting {

    // Customize Project Setting -------------------------------------------------------------------
    const val NAME_APP = "Nutrition Framework"

    private const val APP_DOMAIN = "com"
    private const val APP_PLAY_CONSOLE = "frogobox"
    private const val BASE_PACKAGE = "nutrition"

    private const val VERSION_MAJOR = 1
    private const val VERSION_MINOR = 0
    private const val VERSION_PATCH = 0

    const val PROJECT_COMPILE_SDK = 31
    const val PROJECT_MIN_SDK = 21

    // Key Store
    const val PLAYSTORE_STORE_FILE = "frogoboxdev.jks"
    const val PLAYSTORE_STORE_PASSWORD = "cronoclez"
    const val PLAYSTORE_KEY_ALIAS = "frogobox"
    const val PLAYSTORE_KEY_PASSWORD = "xeonranger"

    // Default Project Setting (Do not Changed it) -------------------------------------------------

    // Declaration apps name debug mode
    const val debugAttribute = "Development"
    const val nameAppDebug = "$NAME_APP $debugAttribute"

    val NAME_APK = NAME_APP.toLowerCase().replace(" ", "-")
    val NAME_DB = NAME_APP.toLowerCase().replace(" ", "_")
    val DB = "\"$NAME_DB.db\""

    const val PROJECT_TARGET_SDK = PROJECT_COMPILE_SDK

    const val PACKAGE_NAME_APP = "${BASE_PACKAGE}app"
    const val PACKAGE_NAME_LIBRARY_CORE = "${BASE_PACKAGE}core"
    const val PACKAGE_NAME_LIBRARY_FRAMEWORK = "${BASE_PACKAGE}framework"

    const val PROJECT_APP_ID = "$APP_DOMAIN.$APP_PLAY_CONSOLE.$PACKAGE_NAME_APP"

    const val PROJECT_LIB_ID_FRAMEWORK =
        "$APP_DOMAIN.$APP_PLAY_CONSOLE.$PACKAGE_NAME_LIBRARY_FRAMEWORK"
    const val PROJECT_LIB_ID_CORE = "$APP_DOMAIN.$APP_PLAY_CONSOLE.$PACKAGE_NAME_LIBRARY_CORE"

    const val PROJECT_VERSION_CODE =
        (VERSION_MAJOR * 100) + (VERSION_MINOR * 10) + (VERSION_PATCH * 1)
    const val PROJECT_VERSION_NAME = "$VERSION_MAJOR.$VERSION_MINOR.$VERSION_PATCH"

    // Please Add Your Code Under This Line --------------------------------------------------------

}