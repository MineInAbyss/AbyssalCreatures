package com.mineinabyss.abyssalcreatures.mobs.hostile

import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.HostileMob
import net.minecraft.server.v1_15_R1.PathfinderGoalLeapAtTarget
import net.minecraft.server.v1_15_R1.World

class Kuongatari(world: World?) : HostileMob(world, "Kuongatari"), HitBehaviour {
    override fun createPathfinders() {
        super.createPathfinders()
        addPathfinderGoal(1, PathfinderGoalLeapAtTarget(this, 0.6f))
    }
}