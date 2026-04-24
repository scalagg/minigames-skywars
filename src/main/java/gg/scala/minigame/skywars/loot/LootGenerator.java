package gg.scala.minigame.skywars.loot;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public abstract class LootGenerator {

    public int rotation;

    public LootGenerator() {
        this.rotation = 0;
    }

    public abstract List<ItemStack> basic();

    public abstract List<ItemStack> middle();

    public abstract List<ItemStack> mystic();

    protected boolean isDiamond(Material type) {
        switch (type) {
            case DIAMOND_HELMET:
            case DIAMOND_CHESTPLATE:
            case DIAMOND_LEGGINGS:
            case DIAMOND_BOOTS: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    protected boolean isIron(Material type) {
        switch (type) {
            case IRON_HELMET:
            case IRON_CHESTPLATE:
            case IRON_LEGGINGS:
            case IRON_BOOTS: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public ItemStack name(Material material, String name, String... lore) {
        return name(new ItemStack(material), name, lore);
    }

    public ItemStack name(ItemStack itemStack, String name, String... lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        if(lore.length > 0) {
            itemMeta.setLore(Arrays.asList(lore));
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack name(ItemStack itemStack, String name, List<String> lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        if(!lore.isEmpty()) {
            itemMeta.setLore(lore);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
