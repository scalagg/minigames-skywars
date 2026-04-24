package gg.scala.minigame.skywars.events

import gg.scala.minigame.skywars.SkyWarsLifecycle
import java.time.Duration

class GameEndGameEvent(
    lifecycle: SkyWarsLifecycle,
    description: String,
    duration: Duration
) : GameEvent(lifecycle, description, duration)
{

    override fun execute()
    {
        lifecycle.game.complete(null)
    }
}
