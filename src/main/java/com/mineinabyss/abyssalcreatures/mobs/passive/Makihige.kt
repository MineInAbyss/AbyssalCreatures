package com.mineinabyss.abyssalcreatures.mobs.passive

import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.PassiveMob
import net.minecraft.server.v1_15_R1.EntityHuman
import net.minecraft.server.v1_15_R1.PathfinderGoalAvoidTarget
import net.minecraft.server.v1_15_R1.World

class Makihige(world: World?) : PassiveMob(world, "Makihige"), HitBehaviour {
    override fun onRightClick(player: EntityHuman) {
        player.startRiding(this)
    }

    override fun createPathfinders() {
        super.createPathfinders()
        addPathfinderGoal(1, PathfinderGoalAvoidTarget(this, EntityHuman::class.java, 8.0f, 1.0, 1.0))
    }
}