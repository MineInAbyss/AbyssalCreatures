import io.github.offz.githubPackage
import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    java
    idea
    id("com.github.johnrengelman.shadow")
    kotlin("jvm")
    id("io.github.0ffz.github-packages") version "1.0.1"
}

val kotlin_version: String by project
val server_version: String by project

group = "com.mineinabyss"
val version: String = "${properties["plugin_version"]}${properties["buildNo"] ?: ""}"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://erethon.de/repo/") //HeadLib

//    maven("https://hub.spigotmc.org/nexus/content/groups/public/")
//    maven("https://jitpack.io")
    maven("https://repo.dmulloy2.net/nexus/repository/public/") //lol these guys have NMS in there
//    maven("https://maven.sk89q.com/repo/")
    githubPackage("MineInAbyss/Idofront")
    githubPackage("MineInAbyss/KotlinSpice")
    mavenLocal()
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:$server_version") //Spigot
    compileOnly("org.spigotmc:spigot:$server_version") // NMS
    compileOnly("de.erethon:headlib:3.0.2")
    compileOnly("org.cultofclang.minecraft:kotlinspice:$kotlin_version+")
    compileOnly("com.mineinabyss:mobzy")

    implementation("com.mineinabyss:idofront:0.2.+")
}

tasks {
    shadowJar {
        archiveBaseName.set("AbyssalCreatures")
        archiveVersion.set(this@Build_gradle.version)
        archiveClassifier.set("")
        relocate("com.mineinabyss.idofront", "${project.group}.${project.name}.idofront".toLowerCase())
        minimize()
    }

    processResources {
        println("Replacing tokens")
        filter<ReplaceTokens>("tokens" to mapOf("plugin_version" to version.also { println("Using version $version") }))
    }

    //Move into plugins folder
    val plugin_path: String? by project
    if (plugin_path != null) {
        register<Copy>("copyJar") {
            println("Copying to plugin directory $plugin_path")
            from(shadowJar) // here it automatically reads jar file produced from jar task
            into(plugin_path!!)
        }
    }

    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    build {
        dependsOn("copyJar", "processResources")
//        dependsOn(gradle.includedBuild("Mobzy").task(":copyJar"))
    }
}