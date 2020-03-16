package com.mineinabyss.abyssalcreatures

import com.mineinabyss.mobzy.MobzyAddon
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class AbyssalCreatures : JavaPlugin(), MobzyAddon {
    override fun onEnable() {
        logger.info("Enabling AbyssalCreatures")
        saveDefaultConfig()
        registerWithMobzy()
    }

    override fun onDisable() {
        logger.info("Disabling AbyssalCreatures")
    }

    override val mobConfig = File(dataFolder, "mobs.yml")
    override val spawnConfig = File(dataFolder, "spawns.yml")
    override val initializeMobs: () -> Unit = { AbyssalType() }
}