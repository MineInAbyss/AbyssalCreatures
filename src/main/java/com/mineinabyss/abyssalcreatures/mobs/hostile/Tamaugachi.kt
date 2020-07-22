package com.mineinabyss.abyssalcreatures.mobs.hostile

import com.mineinabyss.idofront.items.editItemMeta
import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.HostileMob
import net.minecraft.server.v1_16_R1.World
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

class Tamaugachi(world: World?) : HostileMob(world, "Tamaugachi"), HitBehaviour {
    init {
        //make them walk fast in water thanks to depth strider. The material can't be boots since they'll display even
        // if the entity is invisible
        living.equipment!!.boots = ItemStack(Material.STONE).editItemMeta {
            isUnbreakable = true
            addEnchant(Enchantment.DEPTH_STRIDER, 40, true)
        }
    }
}