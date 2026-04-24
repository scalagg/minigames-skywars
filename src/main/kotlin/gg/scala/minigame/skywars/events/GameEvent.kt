package gg.scala.minigame.skywars.events

import gg.scala.minigame.skywars.SkyWarsLifecycle
import gg.tropic.practice.minigame.MiniGameEvent
import net.evilblock.cubed.util.time.TimeUtil
import java.time.Duration
import kotlin.math.max

abstract class GameEvent(
    val lifecycle: SkyWarsLifecycle,
    private val name: String,
    val durationPostGameStart: Duration
): Runnable, MiniGameEvent
{
    var start: Long = 0L

    override val description: String
        get() = name

    override val duration: Duration
        get() = durationPostGameStart

    override fun run()
    {
        execute()
    }

    fun describe() = "$name ${
        if (isNow()) "NOW!" else TimeUtil.formatIntoMMSS((millisUntilExecution() / 1000L).toInt())
    }"

    fun formattedEstimatedExecution() = TimeUtil.formatIntoMMSS((millisUntilExecution() / 1000L).toInt())
    fun isNow() = estimatedExecution() - System.currentTimeMillis() < 0
    fun millisUntilExecution() = max(0, estimatedExecution() - System.currentTimeMillis())
    fun estimatedExecution() = durationPostGameStart
        .plusMillis(start)
        .toMillis()
}
