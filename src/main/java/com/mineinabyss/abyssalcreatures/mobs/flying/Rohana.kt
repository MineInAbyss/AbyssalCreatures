package com.mineinabyss.abyssalcreatures.mobs.flying

import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.FlyingMob
import com.mineinabyss.mobzy.pathfinders.flying.PathfinderGoalFlyDamageTarget
import com.mineinabyss.mobzy.pathfinders.flying.PathfinderGoalFlyTowardsTarget
import com.mineinabyss.mobzy.pathfinders.flying.PathfinderGoalHurtByTarget
import com.mineinabyss.mobzy.pathfinders.flying.PathfinderGoalIdleFlyAboveGround
import net.minecraft.server.v1_16_R1.PathfinderGoalFloat
import net.minecraft.server.v1_16_R1.World

class Rohana(world: World?) : FlyingMob(world, "Rohana"), HitBehaviour {
    override fun createPathfinders() {
        addPathfinderGoal(1, PathfinderGoalFloat(this))
        addPathfinderGoal(1, PathfinderGoalFlyDamageTarget(this))
        addPathfinderGoal(3, PathfinderGoalFlyTowardsTarget(this))
        addPathfinderGoal(7, PathfinderGoalIdleFlyAboveGround(this))
        addPathfinderGoal(1, PathfinderGoalHurtByTarget(this)) //TODO convert to targetSelector
    }
}