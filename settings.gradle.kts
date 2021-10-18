pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
rootProject.name = "NutritionFramework"
include(":nutritionapp", ":nutritionframework", ":nutritioncore")