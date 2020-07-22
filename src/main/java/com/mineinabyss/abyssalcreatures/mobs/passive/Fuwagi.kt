package com.mineinabyss.abyssalcreatures.mobs.passive

import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.PassiveMob
import com.mineinabyss.mobzy.pathfinders.TemptGoal
import net.minecraft.server.v1_16_R1.EntityHuman
import net.minecraft.server.v1_16_R1.PathfinderGoalAvoidTarget
import net.minecraft.server.v1_16_R1.World

class Fuwagi(world: World?) : PassiveMob(world, "Fuwagi"), HitBehaviour {
    override val soundHurt = "entity.rabbit.attack"
    override val soundAmbient = "entity.rabbit.ambient"
    override val soundStep = "entity.rabbit.jump"
    override val soundDeath = "entity.rabbit.death"

    override fun createPathfinders() {
        super.createPathfinders()
        addPathfinderGoal(1, PathfinderGoalAvoidTarget(this, EntityHuman::class.java, 8.0f, 1.0, 1.0))
        addPathfinderGoal(4, TemptGoal(this, template.temptItems))
    }
}