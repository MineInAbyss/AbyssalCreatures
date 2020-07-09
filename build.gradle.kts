import io.github.offz.githubPackage
import org.apache.tools.ant.filters.ReplaceTokens

plugins {
    java
    idea
    id("com.github.johnrengelman.shadow")
    kotlin("jvm")
    kotlin("kapt") version "1.3.72"
    id("io.github.0ffz.github-packages") version "1.0.1"
}

val kotlin_version: String by project

group = "com.mineinabyss"
val version: String = "${properties["plugin_version"]}${properties["buildNo"] ?: ""}"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://erethon.de/repo/") //HeadLib
    githubPackage("MineInAbyss/Idofront")
    githubPackage("CultOfClang/KotlinSpice")
    mavenLocal()
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.15-R0.1-SNAPSHOT") //Spigot
    compileOnly("org.spigotmc:spigot:1.15-R0.1-SNAPSHOT") // NMS
    compileOnly("de.erethon:headlib:3.0.2")
    compileOnly("org.cultofclang.minecraft:kotlinspice:$kotlin_version+")
    compileOnly("com.mineinabyss:mobzy")

    implementation("com.mineinabyss:idofront")
    implementation("com.mineinabyss:idofront-annotation")
    kapt("com.mineinabyss:idofront-processor")
}

tasks {
    shadowJar {
        archiveBaseName.set("AbyssalCreatures")
        archiveVersion.set(this@Build_gradle.version)
        archiveClassifier.set("")
        relocate("com.mineinabyss.idofront", "${project.group}.${project.name}.idofront".toLowerCase())
        minimize()
    }

    register<ProcessResources>("replaceTokens") {
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
        dependsOn("copyJar", "replaceTokens")
    }
}