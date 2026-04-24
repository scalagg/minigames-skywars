package gg.scala.minigame.skywars.chests

import gg.scala.commons.spatial.Position
import gg.scala.commons.spatial.toPosition
import gg.scala.minigame.skywars.SkyWarsLifecycle
import gg.scala.minigame.skywars.loot.StandardLootGenerator
import org.bukkit.block.Block
import org.bukkit.block.Chest
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import kotlin.random.Random

class ChestController(private val game: SkyWarsLifecycle)
{
    val chests = mutableMapOf<String, List<Position>>()

    fun chestByBlock(block: Block) = chests.values.flatten()
        .filter {
            it.isEqualToVector(block.location.toPosition())
        }

    fun chestByScope(scope: String = "global") = chests[scope] ?: listOf()

    fun Inventory.populateSmart(items: List<ItemStack>, includeAll: Boolean = false)
    {
        val newContents = arrayOfNulls<ItemStack>(27)
        for ((index, item) in items.withIndex())
        {
            if (includeAll || Random.nextBoolean())
            {
                newContents[index] = item
            }
        }

        newContents.shuffle()
        contents = newContents
    }

    fun refillAll()
    {
        val gameWorld = game.game.arenaWorld
            ?: return

        chests["global"]?.onEach {
            val position = it.toLocation(gameWorld)
            if (position.block.state is Chest)
            {
                val inventory = (position.block.state as Chest).inventory
                inventory.populateSmart(StandardLootGenerator.INSTANCE.middle())
            }
        }

        chests.entries
            .filterNot { it.key == "global" }
            .onEach {
                val islandLoot = StandardLootGenerator.INSTANCE.basic()
                val chunked = islandLoot.chunked(islandLoot.size / it.value.size)
                it.value.forEachIndexed { index, chest ->
                    val lootForChest = chunked.getOrNull(index)
                        ?: listOf()
                    val position = chest.toLocation(gameWorld)

                    val inventory = (position.block.state as Chest).inventory
                    inventory.populateSmart(lootForChest, includeAll = true)
                }
            }
    }
}
