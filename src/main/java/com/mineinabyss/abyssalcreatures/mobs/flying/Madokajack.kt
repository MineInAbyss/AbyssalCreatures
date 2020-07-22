package com.mineinabyss.abyssalcreatures.mobs.flying

import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.FlyingMob
import com.mineinabyss.mobzy.pathfinders.flying.PathfinderGoalDiveOnTargetAttack
import net.minecraft.server.v1_16_R1.World

class Madokajack(world: World?) : FlyingMob(world, "Madokajack"), HitBehaviour {
    override fun createPathfinders() {
        super.createPathfinders()
        addPathfinderGoal(2, PathfinderGoalDiveOnTargetAttack(
                this,
                minHeight = 6.0,
                maxHeight = 10.0,
                startDiveDistance = 14.0,
                bashVelMultiplier = 1.0
        ))
    }
}