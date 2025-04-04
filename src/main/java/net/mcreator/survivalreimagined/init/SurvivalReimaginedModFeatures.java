
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.core.registries.Registries;

import net.mcreator.survivalreimagined.world.features.StoneGenFeature;
import net.mcreator.survivalreimagined.world.features.FlintGenFeature;
import net.mcreator.survivalreimagined.world.features.CopperGenFeature;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class SurvivalReimaginedModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(Registries.FEATURE, SurvivalReimaginedMod.MODID);
	public static final DeferredHolder<Feature<?>, Feature<?>> FLINT_GEN = REGISTRY.register("flint_gen", FlintGenFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> STONE_GEN = REGISTRY.register("stone_gen", StoneGenFeature::new);
	public static final DeferredHolder<Feature<?>, Feature<?>> COPPER_GEN = REGISTRY.register("copper_gen", CopperGenFeature::new);
}
