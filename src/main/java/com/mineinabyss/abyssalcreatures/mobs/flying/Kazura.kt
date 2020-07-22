package com.mineinabyss.abyssalcreatures.mobs.flying

import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.FlyingMob
import com.mineinabyss.mobzy.pathfinders.flying.FlyDamageTargetGoal
import com.mineinabyss.mobzy.pathfinders.flying.FlyTowardsTargetGoal
import com.mineinabyss.mobzy.pathfinders.flying.IdleFlyAboveGroundGoal
import net.minecraft.server.v1_16_R1.EntityHuman
import net.minecraft.server.v1_16_R1.PathfinderGoalFloat
import net.minecraft.server.v1_16_R1.PathfinderGoalNearestAttackableTarget
import net.minecraft.server.v1_16_R1.World

class Kazura(world: World?) : FlyingMob(world, "Kazura"), HitBehaviour {
    override fun createPathfinders() {
        addPathfinderGoal(0, PathfinderGoalFloat(this))
        addPathfinderGoal(1, FlyDamageTargetGoal(this))
        addPathfinderGoal(3, FlyTowardsTargetGoal(this))
        addPathfinderGoal(7, IdleFlyAboveGroundGoal(this, 2.0, 16.0))
        addTargetSelector(1, PathfinderGoalNearestAttackableTarget(this, EntityHuman::class.java, true))
    }
}