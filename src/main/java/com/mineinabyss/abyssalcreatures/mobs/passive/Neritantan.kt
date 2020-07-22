package com.mineinabyss.abyssalcreatures.mobs.passive

import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.PassiveMob
import com.mineinabyss.mobzy.pathfinders.PathfinderGoalTemptPitchLock
import net.minecraft.server.v1_16_R1.World

class Neritantan(world: World?) : PassiveMob(world, "Neritantan"), HitBehaviour {
    override fun createPathfinders() {
        super.createPathfinders()
        addPathfinderGoal(4, PathfinderGoalTemptPitchLock(this, template.temptItems))
    }
}