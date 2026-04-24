package gg.scala.minigame.skywars.events

import me.lucko.helper.Helper
import net.kyori.adventure.platform.bukkit.BukkitAudiences

object GlobalAudiences
{
    val audiences by lazy { BukkitAudiences.create(Helper.hostPlugin()) }
}
