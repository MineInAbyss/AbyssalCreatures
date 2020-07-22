package com.mineinabyss.abyssalcreatures.mobs.passive

import com.mineinabyss.mobzy.mobs.types.PassiveMob
import com.mineinabyss.mobzy.pathfinders.LookAtPlayerGoal
import net.minecraft.server.v1_16_R1.*

class NPC(world: World?, name: String) : PassiveMob(world, name) {
    //Stop from being pushed around
    override fun move(enummovetype: EnumMoveType?, vec3d: Vec3D?) = Unit

    override fun collide(entity: Entity) = Unit

    //Prevent NPCs from getting damaged by anything
    override fun damageEntity(damagesource: DamageSource, f: Float) = false

    override fun createPathfinders() {
        addPathfinderGoal(2, PathfinderGoalRandomLookaround(this))
        addPathfinderGoal(7, LookAtPlayerGoal(this, EntityPlayer::class, 6.0f, 0.02f))
    }

    init {
        living.customName = name
        customNameVisible = true
        isInvulnerable = true
        addScoreboardTag("npc")
        living.removeWhenFarAway = false
    }
}
