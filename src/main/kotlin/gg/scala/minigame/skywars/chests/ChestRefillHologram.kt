package gg.scala.minigame.skywars.chests

import gg.scala.minigame.skywars.events.GameEvent
import me.lucko.helper.Helper
import net.evilblock.cubed.entity.EntityHandler
import net.evilblock.cubed.entity.hologram.updating.UpdatingHologramEntity
import net.evilblock.cubed.util.CC
import org.bukkit.Location
import org.bukkit.block.Chest
import org.bukkit.metadata.FixedMetadataValue

class ChestRefillHologram(
    private val associatedEvent: GameEvent,
    location: Location
) : UpdatingHologramEntity(
    "", location
), AutoCloseable
{
    override fun close()
    {
        ChestPacketCreator.closeChest(location)

        location.block.removeMetadata("hologram", Helper.hostPlugin())

        destroyForCurrentWatchers()
        EntityHandler.forgetEntity(this)
    }

    fun create()
    {
        ChestPacketCreator.openChest(location)
        location.block.setMetadata("hologram", FixedMetadataValue(Helper.hostPlugin(), this))

        initializeData()
        EntityHandler.trackEntity(this)
    }

    override fun getNewLines(): List<String>
    {
        val chest = location.block.state as Chest
        return listOf("${CC.GREEN}${associatedEvent}") + if (chest.inventory.contents.all { it == null })
        {
            listOf("", "${CC.RED}Empty!")
        } else
        {
            emptyList()
        }
    }

    override fun getTickInterval() = 500L
}
