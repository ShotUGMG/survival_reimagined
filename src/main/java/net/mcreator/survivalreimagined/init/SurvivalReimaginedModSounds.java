/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class SurvivalReimaginedModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, SurvivalReimaginedMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_CARVING_CRAFTING_TABLE = REGISTRY.register("block.carving_crafting_table",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "block.carving_crafting_table")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_CARVE_PROGRESS = REGISTRY.register("block.carve_progress",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "block.carve_progress")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FORGE_OPEN = REGISTRY.register("forge_open", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "forge_open")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CLOSE_FORGE = REGISTRY.register("close_forge", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "close_forge")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PLAYER_DIGGING_STONE = REGISTRY.register("player_digging.stone",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "player_digging.stone")));
	public static final DeferredHolder<SoundEvent, SoundEvent> LIMB_REMOVE = REGISTRY.register("limb_remove", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "limb_remove")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CHIMES = REGISTRY.register("chimes", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "chimes")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOODZOMBIE_HURT = REGISTRY.register("bloodzombie_hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "bloodzombie_hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOODZOMBIE_IDLE = REGISTRY.register("bloodzombie_idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "bloodzombie_idle")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOODZOMBIE_DEATH = REGISTRY.register("bloodzombie_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "bloodzombie_death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PORTAL_OPEN = REGISTRY.register("portal_open", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "portal_open")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOODMOON_SONG = REGISTRY.register("bloodmoon_song", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "bloodmoon_song")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MPT_AMBIENCE = REGISTRY.register("mpt/ambience", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "mpt/ambience")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_SHALE_MOSS_STEP = REGISTRY.register("block/shale_moss_step",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "block/shale_moss_step")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_MOSSY_SHALE_PLACE = REGISTRY.register("block/mossy_shale_place",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "block/mossy_shale_place")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_RADIATED_FOREST = REGISTRY.register("ambient/radiated_forest",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "ambient/radiated_forest")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MUSIC_RADIANT_ABYSS = REGISTRY.register("music/radiant_abyss",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "music/radiant_abyss")));
	public static final DeferredHolder<SoundEvent, SoundEvent> RADIATION_DAMAGE = REGISTRY.register("radiation/damage", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "radiation/damage")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GASMASK_FILTER = REGISTRY.register("gasmask/filter", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "gasmask/filter")));
	public static final DeferredHolder<SoundEvent, SoundEvent> NETHERITE_SCRAP_SOUNDS = REGISTRY.register("netherite_scrap/sounds",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "netherite_scrap/sounds")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GEODE_CRACK = REGISTRY.register("geode/crack", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "geode/crack")));
	public static final DeferredHolder<SoundEvent, SoundEvent> ECLIPSE_GUST = REGISTRY.register("eclipse_gust", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "eclipse_gust")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GAS_MASK_BREATH = REGISTRY.register("gas_mask_breath", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "gas_mask_breath")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FILTER_MENDS = REGISTRY.register("filter_mends", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "filter_mends")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CRIMSON_ARACHNID_AMBIENT = REGISTRY.register("crimson_arachnid/ambient",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "crimson_arachnid/ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CRIMSON_ARACHNID_DEATH = REGISTRY.register("crimson_arachnid/death",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "crimson_arachnid/death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CRIMSON_ARACHNID_HURT = REGISTRY.register("crimson_arachnid/hurt",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "crimson_arachnid/hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GHOST_CREEPER_DEATH = REGISTRY.register("ghost_creeper/death",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "ghost_creeper/death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GHOST_CREEPER_HIT = REGISTRY.register("ghost_creeper/hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "ghost_creeper/hit")));
	public static final DeferredHolder<SoundEvent, SoundEvent> GHOST_CREEPER_AMBIENT = REGISTRY.register("ghost_creeper/ambient",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "ghost_creeper/ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SKELETON_MOB_HURT = REGISTRY.register("skeleton_mob/hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "skeleton_mob/hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SKELETON_MOB_DEATH = REGISTRY.register("skeleton_mob/death",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "skeleton_mob/death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BREAK_WISTERIA_LITTER = REGISTRY.register("break/wisteria_litter",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "break/wisteria_litter")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PLACE_WISTERA_LITTER = REGISTRY.register("place/wistera_litter",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "place/wistera_litter")));
	public static final DeferredHolder<SoundEvent, SoundEvent> STEP_WISTERA_LITTER = REGISTRY.register("step/wistera_litter",
			() -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "step/wistera_litter")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_STEEL_PLACE = REGISTRY.register("block/steel_place", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "block/steel_place")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_STEEL_STEP = REGISTRY.register("block/steel_step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "block/steel_step")));
	public static final DeferredHolder<SoundEvent, SoundEvent> FLINT_SCRAPE = REGISTRY.register("flint_scrape", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "flint_scrape")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DEMON_DEATH = REGISTRY.register("demon/death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "demon/death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DEMON_HIT = REGISTRY.register("demon/hit", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "demon/hit")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DEMON_AMBIENT = REGISTRY.register("demon/ambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "demon/ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DEMON_STEP = REGISTRY.register("demon/step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "demon/step")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_BAOR = REGISTRY.register("ambient/baor", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "ambient/baor")));
	public static final DeferredHolder<SoundEvent, SoundEvent> DEATH_BOAR = REGISTRY.register("death/boar", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "death/boar")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HIT_BOAR = REGISTRY.register("hit/boar", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "hit/boar")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SQUEAL_BOAR = REGISTRY.register("squeal/boar", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "squeal/boar")));
	public static final DeferredHolder<SoundEvent, SoundEvent> AMBIENT_PIGLET = REGISTRY.register("ambient/piglet", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "ambient/piglet")));
	public static final DeferredHolder<SoundEvent, SoundEvent> HURT_PIGLET = REGISTRY.register("hurt/piglet", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "hurt/piglet")));
	public static final DeferredHolder<SoundEvent, SoundEvent> SQUEAL_PIGLET = REGISTRY.register("squeal/piglet", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "squeal/piglet")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BARREL_SEAL = REGISTRY.register("barrel/seal", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "barrel/seal")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MILLSTONE = REGISTRY.register("millstone", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "millstone")));
}