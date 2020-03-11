package com.mineinabyss.abyssalcreatures

import com.mineinabyss.mobzy.*
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class AbyssalCreatures : JavaPlugin(), MobzyAddon {
    override fun onEnable() {
        logger.info("On enable has been called")
        saveDefaultConfig()
        registerWithMobzy(mobzy)
    }

    override fun onDisable() {
        super.onDisable()
        // Plugin shutdown logic
        logger.info("onDisable has been invoked!")
    }

    override fun registerWithMobzy(mobzy: Mobzy) {
        registerMobConfig(File(dataFolder, "mobs.yml"), this)
        AbyssalType()
        registerSpawnConfig(File(dataFolder, "spawns.yml"), this)
        mobzy.reloadExistingEntities()
    }
}