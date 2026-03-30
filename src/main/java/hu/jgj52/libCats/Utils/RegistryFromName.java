package hu.jgj52.libCats.Utils;

import io.papermc.paper.datacomponent.DataComponentType;
import io.papermc.paper.dialog.Dialog;
import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.TypedKey;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Biome;
import org.bukkit.block.BlockType;
import org.bukkit.block.banner.PatternType;
import org.bukkit.damage.DamageType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.generator.structure.Structure;
import org.bukkit.generator.structure.StructureType;
import org.bukkit.inventory.ItemType;
import org.bukkit.inventory.MenuType;
import org.bukkit.inventory.meta.trim.TrimMaterial;
import org.bukkit.inventory.meta.trim.TrimPattern;
import org.bukkit.map.MapCursor;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.ApiStatus;

import java.util.List;

public class RegistryFromName {
    @StableSince("1.21.4")
    public static Attribute ATTRIBUTE(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.ATTRIBUTE).get(TypedKey.create(RegistryKey.ATTRIBUTE, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static PatternType BANNER_PATTERN(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.BANNER_PATTERN).get(TypedKey.create(RegistryKey.BANNER_PATTERN, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static Biome BIOME(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.BIOME).get(TypedKey.create(RegistryKey.BIOME, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static BlockType BLOCK(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.BLOCK).get(TypedKey.create(RegistryKey.BLOCK, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static Cat.Type CAT_VARIANT(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.CAT_VARIANT).get(TypedKey.create(RegistryKey.CAT_VARIANT, Key.key(name)));
    }

    @ApiStatus.AvailableSince("1.21.8")
    @StableSince("1.21.4")
    public static Chicken.Variant CHICKEN_VARIANT(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.CHICKEN_VARIANT).get(TypedKey.create(RegistryKey.CHICKEN_VARIANT, Key.key(name)));
    }

    @ApiStatus.AvailableSince("1.21.8")
    @StableSince("1.21.4")
    public static Cow.Variant COW_VARIANT(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.COW_VARIANT).get(TypedKey.create(RegistryKey.COW_VARIANT, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static DamageType DAMAGE_TYPE(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.DAMAGE_TYPE).get(TypedKey.create(RegistryKey.DAMAGE_TYPE, Key.key(name)));
    }

    @ApiStatus.AvailableSince("1.21.3")
    @ApiStatus.Experimental
    @StableSince("1.21.4")
    public static DataComponentType DATA_COMPONENT_TYPE(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.DATA_COMPONENT_TYPE).get(TypedKey.create(RegistryKey.DATA_COMPONENT_TYPE, Key.key(name)));
    }

    @ApiStatus.AvailableSince("1.21.8")
    @StableSince("1.21.4")
    public static Dialog DIALOG(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.DIALOG).get(TypedKey.create(RegistryKey.DIALOG, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static Enchantment ENCHANTMENT(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.ENCHANTMENT).get(TypedKey.create(RegistryKey.ENCHANTMENT, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static EntityType ENTITY_TYPE(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.ENTITY_TYPE).get(TypedKey.create(RegistryKey.ENTITY_TYPE, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static Fluid FLUID(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.FLUID).get(TypedKey.create(RegistryKey.FLUID, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static Frog.Variant FROG_VARIANT(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.FROG_VARIANT).get(TypedKey.create(RegistryKey.FROG_VARIANT, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static GameEvent GAME_EVENT(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.GAME_EVENT).get(TypedKey.create(RegistryKey.GAME_EVENT, Key.key(name)));
    }

    @ApiStatus.AvailableSince("1.21.11")
    @StableSince("1.21.4")
    public static GameRule<?> GAME_RULE(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.GAME_RULE).get(TypedKey.create(RegistryKey.GAME_RULE, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static MusicInstrument INSTRUMENT(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.INSTRUMENT).get(TypedKey.create(RegistryKey.INSTRUMENT, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static ItemType ITEM(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.ITEM).get(TypedKey.create(RegistryKey.ITEM, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static JukeboxSong JUKEBOX_SONG(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.JUKEBOX_SONG).get(TypedKey.create(RegistryKey.JUKEBOX_SONG, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static MapCursor.Type MAP_DECORATION_TYPE(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.MAP_DECORATION_TYPE).get(TypedKey.create(RegistryKey.MAP_DECORATION_TYPE, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static MemoryKey<?> MEMORY_MODULE_TYPE(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.MEMORY_MODULE_TYPE).get(TypedKey.create(RegistryKey.MEMORY_MODULE_TYPE, Key.key(name)));
    }

    @ApiStatus.AvailableSince("1.21.1")
    @ApiStatus.Experimental
    @StableSince("1.21.4")
    public static MenuType MENU(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.MENU).get(TypedKey.create(RegistryKey.MENU, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static PotionEffectType MOB_EFFECT(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.MOB_EFFECT).get(TypedKey.create(RegistryKey.MOB_EFFECT, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static Art PAINTING_VARIANT(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.PAINTING_VARIANT).get(TypedKey.create(RegistryKey.PAINTING_VARIANT, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static Particle PARTICLE_TYPE(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.PARTICLE_TYPE).get(TypedKey.create(RegistryKey.PARTICLE_TYPE, Key.key(name)));
    }

    @ApiStatus.AvailableSince("1.21.8")
    @StableSince("1.21.4")
    public static Pig.Variant PIG_VARIANT(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.PIG_VARIANT).get(TypedKey.create(RegistryKey.PIG_VARIANT, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static PotionType POTION(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.POTION).get(TypedKey.create(RegistryKey.POTION, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static Sound.Type SOUND_EVENT(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.SOUND_EVENT).get(TypedKey.create(RegistryKey.SOUND_EVENT, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static Structure STRUCTURE(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.STRUCTURE).get(TypedKey.create(RegistryKey.STRUCTURE, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static StructureType STRUCTURE_TYPE(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.STRUCTURE_TYPE).get(TypedKey.create(RegistryKey.STRUCTURE_TYPE, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static TrimMaterial TRIM_MATERIAL(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.TRIM_MATERIAL).get(TypedKey.create(RegistryKey.TRIM_MATERIAL, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static TrimPattern TRIM_PATTERN(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.TRIM_PATTERN).get(TypedKey.create(RegistryKey.TRIM_PATTERN, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static Villager.Profession VILLAGER_PROFESSION(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.VILLAGER_PROFESSION).get(TypedKey.create(RegistryKey.VILLAGER_PROFESSION, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static Villager.Type VILLAGER_TYPE(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.VILLAGER_TYPE).get(TypedKey.create(RegistryKey.VILLAGER_TYPE, Key.key(name)));
    }

    @ApiStatus.AvailableSince("1.21.8")
    @StableSince("1.21.4")
    public static Wolf.SoundVariant WOLF_SOUND_VARIANT(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.WOLF_SOUND_VARIANT).get(TypedKey.create(RegistryKey.WOLF_SOUND_VARIANT, Key.key(name)));
    }

    @StableSince("1.21.4")
    public static Wolf.Variant WOLF_VARIANT(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.WOLF_VARIANT).get(TypedKey.create(RegistryKey.WOLF_VARIANT, Key.key(name)));
    }

    @ApiStatus.AvailableSince("1.21.11")
    @StableSince("1.21.4")
    public static ZombieNautilus.Variant ZOMBIE_NAUTILUS_VARIANT(String name) {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.ZOMBIE_NAUTILUS_VARIANT).get(TypedKey.create(RegistryKey.ZOMBIE_NAUTILUS_VARIANT, Key.key(name)));
    }

    public static List<Attribute> ATTRIBUTE() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.ATTRIBUTE).stream().toList();
    }

    public static List<PatternType> BANNER_PATTERN() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.BANNER_PATTERN).stream().toList();
    }

    public static List<Biome> BIOME() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.BIOME).stream().toList();
    }

    public static List<BlockType> BLOCK() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.BLOCK).stream().toList();
    }

    public static List<Cat.Type> CAT_VARIANT() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.CAT_VARIANT).stream().toList();
    }

    @ApiStatus.AvailableSince("1.21.8")
    public static List<Chicken.Variant> CHICKEN_VARIANT() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.CHICKEN_VARIANT).stream().toList();
    }

    @ApiStatus.AvailableSince("1.21.8")
    public static List<Cow.Variant> COW_VARIANT() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.COW_VARIANT).stream().toList();
    }

    public static List<DamageType> DAMAGE_TYPE() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.DAMAGE_TYPE).stream().toList();
    }

    @ApiStatus.AvailableSince("1.21.3")
    @ApiStatus.Experimental
    public static List<DataComponentType> DATA_COMPONENT_TYPE() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.DATA_COMPONENT_TYPE).stream().toList();
    }

    @ApiStatus.AvailableSince("1.21.8")
    public static List<Dialog> DIALOG() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.DIALOG).stream().toList();
    }

    public static List<Enchantment> ENCHANTMENT() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.ENCHANTMENT).stream().toList();
    }

    public static List<EntityType> ENTITY_TYPE() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.ENTITY_TYPE).stream().toList();
    }

    public static List<Fluid> FLUID() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.FLUID).stream().toList();
    }

    public static List<Frog.Variant> FROG_VARIANT() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.FROG_VARIANT).stream().toList();
    }

    public static List<GameEvent> GAME_EVENT() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.GAME_EVENT).stream().toList();
    }

    @ApiStatus.AvailableSince("1.21.11")
    public static List<GameRule<?>> GAME_RULE() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.GAME_RULE).stream().toList();
    }

    public static List<MusicInstrument> INSTRUMENT() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.INSTRUMENT).stream().toList();
    }

    public static List<ItemType> ITEM() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.ITEM).stream().toList();
    }

    public static List<JukeboxSong> JUKEBOX_SONG() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.JUKEBOX_SONG).stream().toList();
    }

    public static List<MapCursor.Type> MAP_DECORATION_TYPE() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.MAP_DECORATION_TYPE).stream().toList();
    }

    public static List<MemoryKey<?>> MEMORY_MODULE_TYPE() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.MEMORY_MODULE_TYPE).stream().toList();
    }

    @ApiStatus.AvailableSince("1.21.1")
    @ApiStatus.Experimental
    public static List<MenuType> MENU() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.MENU).stream().toList();
    }

    public static List<PotionEffectType> MOB_EFFECT() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.MOB_EFFECT).stream().toList();
    }

    public static List<Art> PAINTING_VARIANT() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.PAINTING_VARIANT).stream().toList();
    }

    public static List<Particle> PARTICLE_TYPE() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.PARTICLE_TYPE).stream().toList();
    }

    @ApiStatus.AvailableSince("1.21.8")
    public static List<Pig.Variant> PIG_VARIANT() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.PIG_VARIANT).stream().toList();
    }

    public static List<PotionType> POTION() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.POTION).stream().toList();
    }

    public static List<org.bukkit.Sound> SOUND_EVENT() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.SOUND_EVENT).stream().toList();
    }

    public static List<Structure> STRUCTURE() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.STRUCTURE).stream().toList();
    }

    public static List<StructureType> STRUCTURE_TYPE() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.STRUCTURE_TYPE).stream().toList();
    }

    public static List<TrimMaterial> TRIM_MATERIAL() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.TRIM_MATERIAL).stream().toList();
    }

    public static List<TrimPattern> TRIM_PATTERN() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.TRIM_PATTERN).stream().toList();
    }

    public static List<Villager.Profession> VILLAGER_PROFESSION() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.VILLAGER_PROFESSION).stream().toList();
    }

    public static List<Villager.Type> VILLAGER_TYPE() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.VILLAGER_TYPE).stream().toList();
    }

    @ApiStatus.AvailableSince("1.21.8")
    public static List<Wolf.SoundVariant> WOLF_SOUND_VARIANT() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.WOLF_SOUND_VARIANT).stream().toList();
    }

    public static List<Wolf.Variant> WOLF_VARIANT() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.WOLF_VARIANT).stream().toList();
    }

    @ApiStatus.AvailableSince("1.21.11")
    public static List<ZombieNautilus.Variant> ZOMBIE_NAUTILUS_VARIANT() {
        return RegistryAccess.registryAccess().getRegistry(RegistryKey.ZOMBIE_NAUTILUS_VARIANT).stream().toList();
    }
}
