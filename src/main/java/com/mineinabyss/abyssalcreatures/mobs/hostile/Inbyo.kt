package com.mineinabyss.abyssalcreatures.mobs.hostile

import com.mineinabyss.abyssalcreatures.mobs.ThrownRock
import com.mineinabyss.abyssalcreatures.mobs.passive.Neritantan
import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.HostileMob
import com.mineinabyss.mobzy.pathfinders.hostile.ItemThrowable
import com.mineinabyss.mobzy.pathfinders.hostile.ThrowItemsGoal
import net.minecraft.server.v1_16_R1.PathfinderGoalNearestAttackableTarget
import net.minecraft.server.v1_16_R1.World

class Inbyo(world: World?) : HostileMob(world, "Inbyo"), HitBehaviour, ItemThrowable {
    override fun createPathfinders() {
        super.createPathfinders()
        addTargetSelector(1, PathfinderGoalNearestAttackableTarget(this, Neritantan::class.java, true))
        addPathfinderGoal(1, ThrowItemsGoal(this, minChaseRad = 0.0, minThrowRad = 7.0))
    }

    override fun createThrownEntity() = ThrownRock(world, this)
}