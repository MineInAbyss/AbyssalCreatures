package com.mineinabyss.abyssalcreatures.mobs.flying

import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.FlyingMob
import com.mineinabyss.mobzy.pathfinders.flying.DiveOnTargetAttackGoal
import net.minecraft.server.v1_16_R1.World

class Dosetori(world: World?) : FlyingMob(world, "Dosetori"), HitBehaviour {
    override fun createPathfinders() {
        super.createPathfinders()
        addPathfinderGoal(2, DiveOnTargetAttackGoal(
                this,
                startDiveDistance = 8.0
        ))
    }
}