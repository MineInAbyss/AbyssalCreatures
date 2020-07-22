package com.mineinabyss.abyssalcreatures.mobs.flying

import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.FlyingMob
import com.mineinabyss.mobzy.pathfinders.flying.DiveOnTargetAttackGoal
import net.minecraft.server.v1_16_R1.World

class CorpseWeeper(world: World?) : FlyingMob(world, "Corpse Weeper"), HitBehaviour {
    override fun createPathfinders() {
        super.createPathfinders()
        addPathfinderGoal(2, DiveOnTargetAttackGoal(this))
    }

    override val soundAmbient = "entity.corpseweeper.snarl2"
    override val soundDeath = "entity.corpseweeper.snarl2"
    override val soundHurt = "entity.corpseweeper.snarl2"
}