package com.mineinabyss.abyssalcreatures.mobs.flying

import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.FlyingMob
import com.mineinabyss.mobzy.pathfinders.flying.PathfinderGoalDiveOnTargetAttack
import net.minecraft.server.v1_15_R1.World

class Cyatoria(world: World?) : FlyingMob(world, "Cyatoria"), HitBehaviour {
    override fun createPathfinders() {
        super.createPathfinders()
        addPathfinderGoal(2, PathfinderGoalDiveOnTargetAttack(
                this,
                startDiveDistance = 8.0,
                bashVelMultiplier = 1.0,
                bashDuration = 20.0
        ))
    }
}