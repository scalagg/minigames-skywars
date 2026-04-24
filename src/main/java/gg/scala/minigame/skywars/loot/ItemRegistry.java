package gg.scala.minigame.skywars.loot;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

public class ItemRegistry {

    public static final List<ItemStack> DIAMOND_ITEMS;

    public static final List<PotionEffectType> EFFECT_TYPES;

    public static final List<Supplier<ItemStack>> IRON_ORE_ITEMS;

    public static final List<Supplier<ItemStack>> FOODS;

    public static final List<Supplier<ItemStack>> BLOCKS;

    public static final List<ItemStack> PICKAXES;

    public static final List<ItemStack> AXES;

    public static final List<ItemStack> SWORDS;

    public static final List<ItemStack> SPADES;

    public static final List<ItemStack> HELMETS;

    public static final List<ItemStack> CHESTPLATES;

    public static final List<ItemStack> LEGGINGS;

    public static final List<ItemStack> BOOTS;

    static {
        DIAMOND_ITEMS = Arrays.asList(new ItemStack(Material.DIAMOND_SWORD), new ItemStack(Material.DIAMOND_PICKAXE), new ItemStack(Material.DIAMOND_AXE), new ItemStack(Material.DIAMOND_HELMET), new ItemStack(Material.DIAMOND_CHESTPLATE), new ItemStack(Material.DIAMOND_LEGGINGS), new ItemStack(Material.DIAMOND_BOOTS));
        EFFECT_TYPES = Arrays.asList(PotionEffectType.SPEED, PotionEffectType.SLOW, PotionEffectType.FAST_DIGGING, PotionEffectType.SLOW_DIGGING, PotionEffectType.INCREASE_DAMAGE, PotionEffectType.JUMP, PotionEffectType.CONFUSION, PotionEffectType.REGENERATION, PotionEffectType.DAMAGE_RESISTANCE, PotionEffectType.FIRE_RESISTANCE, PotionEffectType.INVISIBILITY, PotionEffectType.BLINDNESS, PotionEffectType.NIGHT_VISION, PotionEffectType.HUNGER, PotionEffectType.WEAKNESS, PotionEffectType.POISON, PotionEffectType.WITHER, PotionEffectType.HEALTH_BOOST, PotionEffectType.ABSORPTION, PotionEffectType.SATURATION);
        IRON_ORE_ITEMS = Arrays.asList(() -> new ItemStack(Material.ARROW, ThreadLocalRandom.current().nextInt(4, 10)), () -> new ItemStack(Material.STICK, ThreadLocalRandom.current().nextInt(2, 4)), () -> new ItemStack(Material.FLINT, ThreadLocalRandom.current().nextInt(2, 4)), () -> new ItemStack(Material.STRING, ThreadLocalRandom.current().nextInt(3, 4)), () -> new ItemStack(Material.FEATHER, ThreadLocalRandom.current().nextInt(2, 4)), () -> new ItemStack(Material.COAL, ThreadLocalRandom.current().nextInt(3, 4)), () -> new ItemStack(Material.DIAMOND, ThreadLocalRandom.current().nextInt(1, 2)), () -> new ItemStack(Material.DIAMOND, ThreadLocalRandom.current().nextInt(1, 2)), () -> new ItemStack(Material.IRON_INGOT, ThreadLocalRandom.current().nextInt(1, 3)), () -> new ItemStack(Material.IRON_INGOT, ThreadLocalRandom.current().nextInt(1, 3)));
        FOODS = Arrays.asList(() -> new ItemStack(Material.CARROT_ITEM, ThreadLocalRandom.current().nextInt(8, 32)), () -> new ItemStack(Material.APPLE, ThreadLocalRandom.current().nextInt(8, 32)), () -> new ItemStack(Material.BREAD, ThreadLocalRandom.current().nextInt(8, 32)), () -> new ItemStack(Material.BAKED_POTATO, ThreadLocalRandom.current().nextInt(8, 32)), () -> new ItemStack(Material.COOKED_FISH, ThreadLocalRandom.current().nextInt(8, 32)), () -> new ItemStack(Material.COOKED_BEEF, ThreadLocalRandom.current().nextInt(8, 32)), () -> new ItemStack(Material.COOKED_CHICKEN, ThreadLocalRandom.current().nextInt(8, 32)));
        BLOCKS = Arrays.asList(() -> new ItemStack(Material.STONE, ThreadLocalRandom.current().nextInt(20, 40)), () -> new ItemStack(Material.WOOD, ThreadLocalRandom.current().nextInt(20, 40)), () -> new ItemStack(Material.BRICK, ThreadLocalRandom.current().nextInt(20, 40)), () -> new ItemStack(Material.COBBLESTONE, ThreadLocalRandom.current().nextInt(20, 40)), () -> new ItemStack(Material.STONE, ThreadLocalRandom.current().nextInt(20, 40)), () -> new ItemStack(Material.DIRT, ThreadLocalRandom.current().nextInt(20, 40)));
        PICKAXES = Arrays.asList(new ItemStack(Material.STONE_PICKAXE), new ItemStack(Material.IRON_PICKAXE), new ItemStack(Material.GOLD_PICKAXE), new ItemStack(Material.DIAMOND_PICKAXE));
        AXES = Arrays.asList(new ItemStack(Material.STONE_AXE), new ItemStack(Material.IRON_AXE), new ItemStack(Material.GOLD_AXE), new ItemStack(Material.DIAMOND_AXE));
        SWORDS = Arrays.asList(new ItemStack(Material.STONE_SWORD), new ItemStack(Material.IRON_SWORD), new ItemStack(Material.GOLD_SWORD), new ItemStack(Material.DIAMOND_SWORD));
        SPADES = Arrays.asList(new ItemStack(Material.STONE_SPADE), new ItemStack(Material.IRON_SPADE), new ItemStack(Material.GOLD_SPADE), new ItemStack(Material.DIAMOND_SPADE));
        HELMETS = Arrays.asList(new ItemStack(Material.LEATHER_HELMET), new ItemStack(Material.CHAINMAIL_HELMET), new ItemStack(Material.DIAMOND_HELMET), new ItemStack(Material.GOLD_HELMET), new ItemStack(Material.IRON_HELMET));
        CHESTPLATES = Arrays.asList(new ItemStack(Material.LEATHER_CHESTPLATE), new ItemStack(Material.CHAINMAIL_CHESTPLATE), new ItemStack(Material.DIAMOND_CHESTPLATE), new ItemStack(Material.GOLD_CHESTPLATE), new ItemStack(Material.IRON_CHESTPLATE));
        LEGGINGS = Arrays.asList(new ItemStack(Material.LEATHER_LEGGINGS), new ItemStack(Material.CHAINMAIL_LEGGINGS), new ItemStack(Material.DIAMOND_LEGGINGS), new ItemStack(Material.GOLD_LEGGINGS), new ItemStack(Material.IRON_LEGGINGS));
        BOOTS = Arrays.asList(new ItemStack(Material.LEATHER_BOOTS), new ItemStack(Material.CHAINMAIL_BOOTS), new ItemStack(Material.DIAMOND_BOOTS), new ItemStack(Material.GOLD_BOOTS), new ItemStack(Material.IRON_BOOTS));
    }
}
