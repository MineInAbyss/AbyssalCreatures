package com.mineinabyss.abyssalcreatures

import com.mineinabyss.idofront.messaging.logInfo
import com.mineinabyss.mobzy.MobzyAddon
import com.mineinabyss.mobzy.api.registerAddonWithMobzy
import net.minecraft.server.v1_16_R1.*
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.lang.reflect.Field
import java.lang.reflect.Modifier


fun attributeTest(): AttributeProvider.Builder {
    return EntityMonster.eS().a(GenericAttributes.FOLLOW_RANGE, 35.0).a(GenericAttributes.MOVEMENT_SPEED, 0.45).a(GenericAttributes.ATTACK_DAMAGE, 3.0).a(GenericAttributes.ARMOR, 2.0).a(GenericAttributes.SPAWN_REINFORCEMENTS)
}
class AbyssalCreatures : JavaPlugin(), MobzyAddon {

    init {
        try {
            val modifiers: Field = Field::class.java.getDeclaredField("modifiers")
            modifiers.isAccessible = true
            val field: Field = AttributeDefaults::class.java.getDeclaredField("b")
            modifiers.setInt(field, modifiers.getInt(field) and Modifier.FINAL.inv())
            field.isAccessible = true
            val defaultAttributes = HashMap(field.get(null) as Map<EntityTypes<*>, AttributeProvider>)
            //TODO register automatically
            defaultAttributes[AbyssalType.INBYO] = attributeTest().a()
            defaultAttributes[AbyssalType.TAMAUGACHI] = attributeTest().a()
            field.set(null, defaultAttributes)
        } catch (reason: Throwable) {
            error("Failed to inject custom attribute defaults")
        }
    }

    override fun onEnable() {
        logInfo("Enabling AbyssalCreatures")
        saveDefaultConfig()
        registerAddonWithMobzy()
    }

    override fun onDisable() {
        logInfo("Disabling AbyssalCreatures")
    }

    override val mobConfig = File(dataFolder, "mobs.yml")
    override val spawnConfig = File(dataFolder, "spawns.yml")
    override val initializeMobs = { AbyssalType }
}