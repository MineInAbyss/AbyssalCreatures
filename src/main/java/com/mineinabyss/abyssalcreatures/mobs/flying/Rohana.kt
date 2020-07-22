package com.mineinabyss.abyssalcreatures.mobs.flying

import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.FlyingMob
import com.mineinabyss.mobzy.pathfinders.flying.FlyDamageTargetGoal
import com.mineinabyss.mobzy.pathfinders.flying.FlyTowardsTargetGoal
import com.mineinabyss.mobzy.pathfinders.TargetAttackerGoal
import com.mineinabyss.mobzy.pathfinders.flying.IdleFlyAboveGroundGoal
import net.minecraft.server.v1_16_R1.PathfinderGoalFloat
import net.minecraft.server.v1_16_R1.World

class Rohana(world: World?) : FlyingMob(world, "Rohana"), HitBehaviour {
    override fun createPathfinders() {
        addPathfinderGoal(1, PathfinderGoalFloat(this))
        addPathfinderGoal(1, FlyDamageTargetGoal(this))
        addPathfinderGoal(3, FlyTowardsTargetGoal(this))
        addPathfinderGoal(7, IdleFlyAboveGroundGoal(this))
        addPathfinderGoal(1, TargetAttackerGoal(this)) //TODO convert to targetSelector
    }
}