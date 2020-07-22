package com.mineinabyss.abyssalcreatures.mobs.flying

import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.FlyingMob
import com.mineinabyss.mobzy.pathfinders.flying.DiveOnTargetAttackGoal
import net.minecraft.server.v1_16_R1.World

class Benikuchinawa(world: World?) : FlyingMob(world, "Benikuchinawa"), HitBehaviour {
    override fun createPathfinders() {
        super.createPathfinders()
        addPathfinderGoal(2, DiveOnTargetAttackGoal(
                this,
                diveVelocity = -0.03,
                minHeight = 3.0,
                maxHeight = 5.0
        ))
    }

    override val soundAmbient = "entity.llama.ambient"
    override val soundDeath = "entity.llama.death"
    override val soundHurt = "entity.llama.hurt"

}