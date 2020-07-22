package com.mineinabyss.abyssalcreatures

import com.mineinabyss.abyssalcreatures.mobs.flying.*
import com.mineinabyss.abyssalcreatures.mobs.hostile.*
import com.mineinabyss.abyssalcreatures.mobs.passive.*
import com.mineinabyss.mobzy.api.registerPersistentTemplate
import com.mineinabyss.mobzy.api.registerMob
import com.mineinabyss.mobzy.mobs.MobTemplate
import net.minecraft.server.v1_16_R1.EnumCreatureType.*
import org.bukkit.Material

/**
 * (..., func = ::Neritantan)   is the same as   (...){ world -> Neritantan(world) }   or   (...){ Neritantan(it) }
 */
@Suppress("SpellCheckingInspection", "unused")
object AbyssalType {
    //Passive
    val ASHIMITE = registerMob("ashimite", CREATURE, width = 2f, height = 2f, init = ::Ashimite)
    val FUWAGI = registerMob("fuwagi", CREATURE, width = 0.6f, height = 0.6f, init = ::Fuwagi)
    val MAKIHIGE = registerMob("makihige", WATER_CREATURE, width = 2f, height = 2f, init = ::Makihige)
    val NERITANTAN = registerMob("neritantan", CREATURE, width = 0.6f, height = 0.6f, init = ::Neritantan)
    val OKIBO = registerMob("okibo", CREATURE, width = 2.5f, height = 3f, init = ::Okibo)

    //Hostile
    val INBYO = registerMob("inbyo", MONSTER, width = 0.6f, height = 3f, init = ::Inbyo)
    val KUONGATARI = registerMob("kuongatari", MONSTER, width = 0.7f, height = 0.7f, init = ::Kuongatari)
    val OTTOBAS = registerMob("ottobas", MONSTER, width = 1.9f, height = 2f, init = ::Ottobas)
    val SILKFANG = registerMob("silkfang", MONSTER, width = 1.5f, height = 1.5f, init = ::Silkfang)
    val STEVE = registerMob("steve", MONSTER, width = 2f, height = 7f, init = ::Steve)
    val TAMAUGACHI = registerMob("tamaugachi", MONSTER, width = 1.9f, height = 2.5f, init = ::Tamaugachi)
    val TESUCHI = registerMob("tesuchi", MONSTER, width = 0.6f, height = 0.6f, init = ::Tesuchi)

    //Flying
    //TODO I don't like using MISC for flying creatures, but this is how we're setting them to a separate mob cap for now
    val BENIKUCHINAWA = registerMob("benikuchinawa", MISC, width = 4.5f, height = 2f, init = ::Benikuchinawa)
    val CORPSE_WEEPER = registerMob("corpse_weeper", MISC, width = 3f, height = 3f, init = ::CorpseWeeper)
    val CYATORIA = registerMob("cyatoria", MISC, width = 3f, height = 2f, init = ::Cyatoria)
    val DOSETORI = registerMob("dosetori", MISC, width = 3f, height = 2f, init = ::Dosetori)
    val HAMMERBEAK = registerMob("hammerbeak", MISC, width = 3f, height = 2f, init = ::Hammerbeak)
    val KAZURA = registerMob("kazura", WATER_CREATURE, width = 1f, height = 1f, init = ::Kazura)
    val MADOKAJACK = registerMob("madokajack", MISC, width = 4.5f, height = 3f, init = ::Madokajack)
    val ROHANA = registerMob("rohana", WATER_CREATURE, width = 0.6f, height = 0.6f, init = ::Rohana)

    //NPCs
    private fun registerNPC(name: String, modelID: Int) {
        registerPersistentTemplate(name, MobTemplate(_name = name, model = modelID, modelMaterial = Material.DIAMOND_AXE))
        registerMob(name, MISC, width = 0.6f, height = 2f) { NPC(it, name) }
    }

    val MITTY = registerNPC("Mitty", 2)
    val NANACHI = registerNPC("Nanachi", 3)
    val BONDREWD = registerNPC("Bondrewd", 4)
    val HABO = registerNPC("Habo", 5)
    val JIRUO = registerNPC("Jiruo", 6)
    val KIYUI = registerNPC("Kiyui", 7)
    val MARULK = registerNPC("Marulk", 8)
    val NAT = registerNPC("Nat", 9)
    val OZEN = registerNPC("Ozen", 10)
    val REG = registerNPC("Reg", 11)
    val RIKO = registerNPC("Riko", 12)
    val SHIGGY = registerNPC("Shiggy", 13)
    val TORKA = registerNPC("Torka", 14)
    val LYZA = registerNPC("Lyza", 15)
    val PRUSHKA = registerNPC("Prushka", 16)
}
