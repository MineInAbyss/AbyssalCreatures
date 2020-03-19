package com.mineinabyss.abyssalcreatures.mobs.hostile

import com.mineinabyss.abyssalcreatures.mobs.ThrownRock
import com.mineinabyss.abyssalcreatures.mobs.passive.Neritantan
import com.mineinabyss.idofront.items.editItemMeta
import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.HostileMob
import com.mineinabyss.mobzy.pathfinders.hostile.ItemThrowable
import com.mineinabyss.mobzy.pathfinders.hostile.PathfinderGoalThrowItems
import net.minecraft.server.v1_15_R1.PathfinderGoalNearestAttackableTarget
import net.minecraft.server.v1_15_R1.World
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.craftbukkit.v1_15_R1.inventory.CraftItemStack
import org.bukkit.entity.LivingEntity
import org.bukkit.inventory.ItemStack
import kotlin.random.Random

class Inbyo(world: World?) : HostileMob(world, "Inbyo"), HitBehaviour, ItemThrowable {
    override fun createPathfinders() {
        super.createPathfinders()
        addTargetSelector(1, PathfinderGoalNearestAttackableTarget(this, Neritantan::class.java, true))
        addPathfinderGoal(1, PathfinderGoalThrowItems(this, 0.0, 10.0))
    }

    override val itemToThrow = ItemStack(Material.SNOWBALL).editItemMeta {
        setCustomModelData(3)
    }

    //TODO try not to rely on NMS at all here
    //TODO move some of this code out so it's easier to reuse
    override fun throwItem(target: LivingEntity) {
        val snowball = ThrownRock(world, this)
        val targetLoc = target.eyeLocation
        val dX = targetLoc.x - this.locX
        val dY = targetLoc.y - this.locY - 0.4
        val dZ = targetLoc.z - this.locZ
        living.location.world?.playSound(living.location, Sound.ENTITY_SNOW_GOLEM_SHOOT, 1.0f, 1.0f / (Random.nextDouble(0.8, 1.2).toFloat()))
        snowball.shoot(dX, dY, dZ, 1.6f, 12.0f)
        snowball.setItem(CraftItemStack.asNMSCopy(itemToThrow))
        world.addEntity(snowball)
    }
}