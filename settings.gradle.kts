rootProject.name = "AbyssalCreatures"

includeBuild("../Mobzy")

var useLocalIdofront: String? by extra
if (useLocalIdofront?.toBoolean() == true) includeBuild("../idofront") {
    dependencySubstitution {
        substitute(module("com.mineinabyss:idofront")).with(project(":"))
        substitute(module("com.mineinabyss:idofront-annotation")).with(project(":annotation"))
        substitute(module("com.mineinabyss:idofront-processor")).with(project(":processor"))
    }
}

pluginManagement {
    val kotlin_version: String by settings

    plugins {
        id("com.github.johnrengelman.shadow") version "5.2.0"
        kotlin("jvm") version kotlin_version
    }
}
