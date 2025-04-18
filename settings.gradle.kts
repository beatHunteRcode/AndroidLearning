pluginManagement {
    repositories {
        google()
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
rootProject.name = "AndroidLearning"
include(":app")
include("libs:core:network")
include(":libs:core:arch")
include(":libs:feature")
include(":libs:feature:screens")
include(":libs:core:navigation")
include(":libs:feature:designpatterns")
include(":libs:sharedfeature")
include(":libs:sharedfeature:uikit")
include(":libs:sharedfeature:screentools")
