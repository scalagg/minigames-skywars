package gg.scala.minigame.skywars.chests.utilities

object RandomUtilities
{
    @JvmStatic
    fun <T> of(list: List<T>) = list.randomOrNull()

    @JvmStatic
    fun <T> ofSingle(vararg list: T) = list.randomOrNull()

    @JvmStatic
    fun <T> ofMulti(vararg list: List<T>) = list.flatMap { it }.randomOrNull()
}
