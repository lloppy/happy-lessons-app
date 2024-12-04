pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()    
        mavenCentral()
    }
}

rootProject.name = "Hapson"
include(":app")
include(":core:navigation")
include(":course_feature:presentation")
include(":login_feature:presentation")
include(":profile_feature:presentation")
include(":core:design-system")
include(":data")
