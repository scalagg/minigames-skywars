package gg.scala.minigame.skywars.events

import gg.scala.minigame.skywars.SkyWarsLifecycle
import java.time.Duration

class SecondRefillGameEvent(
    lifecycle: SkyWarsLifecycle,
    description: String = "Refill",
    duration: Duration = Duration.ofSeconds(80)
) : GameEvent(lifecycle, description, duration), ChestRefillEvent
{
    override fun execute()
    {
        lifecycle.chestController.refillAll()
        runEffects(lifecycle.game.arenaWorld!!)
    }
}
