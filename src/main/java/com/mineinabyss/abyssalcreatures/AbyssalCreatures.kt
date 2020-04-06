package com.mineinabyss.abyssalcreatures

import com.mineinabyss.idofront.messaging.logInfo
import com.mineinabyss.mobzy.MobzyAddon
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class AbyssalCreatures : JavaPlugin(), MobzyAddon {
    override fun onEnable() {
        logInfo("Enabling AbyssalCreatures")
        saveDefaultConfig()
        registerWithMobzy()
    }

    override fun onDisable() {
        logInfo("Disabling AbyssalCreatures")
    }

    override val mobConfig = File(dataFolder, "mobs.yml")
    override val spawnConfig = File(dataFolder, "spawns.yml")
    override val initializeMobs = { AbyssalType }
}