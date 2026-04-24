package gg.scala.minigame.skywars.events

import gg.scala.minigame.skywars.SkyWarsLifecycle
import java.time.Duration

class FirstRefillGameEvent(
    lifecycle: SkyWarsLifecycle,
    description: String,
    duration: Duration
) : GameEvent(lifecycle, description, duration), ChestRefillEvent
{
    override fun execute()
    {
        lifecycle.chestController.refillAll()
        runEffects(lifecycle.game.arenaWorld!!)
    }
}
