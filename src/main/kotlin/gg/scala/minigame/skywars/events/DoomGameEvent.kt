package gg.scala.minigame.skywars.events

import gg.scala.minigame.skywars.SkyWarsLifecycle
import java.time.Duration

class DoomGameEvent(
    lifecycle: SkyWarsLifecycle,
    description: String,
    duration: Duration
) : GameEvent(lifecycle, description, duration)
{
    override fun execute()
    {

    }
}
