package com.mineinabyss.abyssalcreatures.mobs.passive

import com.mineinabyss.mobzy.mobs.MobTemplate
import com.mineinabyss.mobzy.mobs.types.PassiveMob
import com.mineinabyss.mobzy.pathfinders.PathfinderGoalLookAtPlayerPitchLock
import net.minecraft.server.v1_15_R1.*
import org.bukkit.entity.LivingEntity

class NPC(world: World?, template: MobTemplate) : PassiveMob(world, template) {
    //Stop from being pushed around
    override fun move(enummovetype: EnumMoveType?, vec3d: Vec3D?) = Unit

    override fun collide(entity: Entity) = Unit

    //Prevent NPCs from getting damaged by anything
    override fun damageEntity(damagesource: DamageSource, f: Float) = false

    override fun createPathfinders() {
        addPathfinderGoal(2, PathfinderGoalRandomLookaround(this))
        addPathfinderGoal(7, PathfinderGoalLookAtPlayerPitchLock(this, EntityTypes.PLAYER, 6.0, 0.02f))
    }

    init {
        living.customName = name
        customNameVisible = true
        isInvulnerable = true
        addScoreboardTag("npc")
        (bukkitEntity as LivingEntity).removeWhenFarAway = false
    }
}
