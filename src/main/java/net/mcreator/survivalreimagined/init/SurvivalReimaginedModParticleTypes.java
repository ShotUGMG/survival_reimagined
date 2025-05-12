
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class SurvivalReimaginedModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, SurvivalReimaginedMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> STONE_GRINDING = REGISTRY.register("stone_grinding", () -> new SimpleParticleType(true));
}
