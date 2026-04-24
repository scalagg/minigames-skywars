package gg.scala.minigame.skywars.events

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.title.TitlePart
import org.bukkit.Sound
import org.bukkit.World

interface ChestRefillEvent
{
    fun runEffects(world: World)
    {
        world.players.forEach {
            GlobalAudiences.audiences.player(it).sendTitlePart(
                TitlePart.TITLE,
                Component
                    .text("Chests have been refilled!")
                    .color(NamedTextColor.YELLOW)
            )

            it.playSound(it.location, Sound.CHEST_OPEN, 2.0f, 0.95f)
        }
    }
}
