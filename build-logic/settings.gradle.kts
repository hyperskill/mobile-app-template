dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
        create("appVersions") {
            from(files("../gradle/app.versions.toml"))
        }
    }
}

rootProject.name = "build-logic"
include(":convention")