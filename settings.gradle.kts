rootProject.name = "AbyssalCreatures"

//includeBuild("../Mobzy")

val useLocalIdofront = extra["useLocalIdofront"].toString().toBoolean()
//if (useLocalIdofront) { TODO get a better solution for toggling working locally
includeBuild("../idofront") {
    dependencySubstitution {
        //doesnt work regardless of whether one or two are defined
        substitute(module("com.mineinabyss:idofront")).with(project(":"))
        substitute(module("com.mineinabyss:idofront-annotation")).with(project(":annotation"))
    }
}
//}

pluginManagement {
    val kotlin_version: String by settings

    plugins {
        id("com.github.johnrengelman.shadow") version "5.2.0"
        kotlin("jvm") version kotlin_version
    }
}