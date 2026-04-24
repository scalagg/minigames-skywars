package gg.scala.minigame.skywars.chests

import me.lucko.helper.utils.Players
import net.minecraft.server.v1_8_R3.Blocks
import net.minecraft.server.v1_8_R3.PacketPlayOutBlockAction
import org.bukkit.Location
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer

object ChestPacketCreator
{
    fun closeChest(chestLocation: Location) =
        sendChestAction(chestLocation, 0)

    fun openChest(chestLocation: Location) =
        sendChestAction(chestLocation, 1)

    private fun sendChestAction(chestLocation: Location, id: Int)
    {
        val pos =
            net.minecraft.server.v1_8_R3.BlockPosition(chestLocation.blockX, chestLocation.blockY, chestLocation.blockZ)
        val packet = PacketPlayOutBlockAction(pos, Blocks.CHEST, 1, id)

        Players.all()
            .forEach {
                (it as CraftPlayer).handle
                    .playerConnection
                    .sendPacket(packet)
            }
    }
}
