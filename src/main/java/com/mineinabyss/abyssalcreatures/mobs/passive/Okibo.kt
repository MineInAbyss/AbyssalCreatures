package com.mineinabyss.abyssalcreatures.mobs.passive

import com.mineinabyss.mobzy.mobs.behaviours.HitBehaviour
import com.mineinabyss.mobzy.mobs.types.PassiveMob
import net.minecraft.server.v1_15_R1.EntityHuman
import net.minecraft.server.v1_15_R1.World

class Okibo(world: World?) : PassiveMob(world, "Okibo"), HitBehaviour {
    override fun onRightClick(player: EntityHuman) {
        player.startRiding(this)
    }
}