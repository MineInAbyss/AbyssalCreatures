package com.mineinabyss.abyssalcreatures.mobs

import com.mineinabyss.idofront.items.editItemMeta
import net.minecraft.server.v1_16_R1.*
import net.minecraft.server.v1_16_R1.MovingObjectPosition.EnumMovingObjectType
import org.bukkit.Material
import org.bukkit.craftbukkit.v1_16_R1.inventory.CraftItemStack
import org.bukkit.inventory.ItemStack

class ThrownRock(world: World?, thrower: EntityLiving) : EntitySnowball(world, thrower) {
    init {
        item = CraftItemStack.asNMSCopy(ItemStack(Material.SNOWBALL).editItemMeta {
            setCustomModelData(3)
        })
    }

    override fun a(mop: MovingObjectPosition) {
        super.a(mop)

        if (mop.type == EnumMovingObjectType.ENTITY) {
            val hit = (mop as MovingObjectPositionEntity).entity
            if (hit is EntityPlayer)
                hit.damageEntity(DamageSource.projectile(this, getShooter()), 0.5f)
        }
    }
}