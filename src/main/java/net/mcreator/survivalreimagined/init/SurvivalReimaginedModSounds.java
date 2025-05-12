
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
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_STEEL_PLACE = REGISTRY.register("block/steel_place", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "block/steel_place")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOCK_STEEL_STEP = REGISTRY.register("block/steel_step", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "block/steel_step")));
	public static final DeferredHolder<SoundEvent, SoundEvent> CHIMES = REGISTRY.register("chimes", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "chimes")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOODZOMBIE_HURT = REGISTRY.register("bloodzombie_hurt", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "bloodzombie_hurt")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOODZOMBIE_IDLE = REGISTRY.register("bloodzombie_idle", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "bloodzombie_idle")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOODZOMBIE_DEATH = REGISTRY.register("bloodzombie_death", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "bloodzombie_death")));
	public static final DeferredHolder<SoundEvent, SoundEvent> PORTAL_OPEN = REGISTRY.register("portal_open", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "portal_open")));
	public static final DeferredHolder<SoundEvent, SoundEvent> BLOODMOON_SONG = REGISTRY.register("bloodmoon_song", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "bloodmoon_song")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MPT_AMBIENCE = REGISTRY.register("mpt/ambience", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("survival_reimagined", "mpt/ambience")));
}
