/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.survivalreimagined.client.particle.*;

@EventBusSubscriber(Dist.CLIENT)
public class SurvivalReimaginedModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(SurvivalReimaginedModParticleTypes.STONE_GRINDING.get(), StoneGrindingParticle::provider);
		event.registerSpriteSet(SurvivalReimaginedModParticleTypes.RADIATED.get(), RadiatedParticle::provider);
		event.registerSpriteSet(SurvivalReimaginedModParticleTypes.RADIATION_PARTICLE.get(), RadiationParticleParticle::provider);
		event.registerSpriteSet(SurvivalReimaginedModParticleTypes.RADIATION_PARTICLE_2.get(), RadiationParticle2Particle::provider);
		event.registerSpriteSet(SurvivalReimaginedModParticleTypes.FALLING_WISTERIA.get(), FallingWisteriaParticle::provider);
		event.registerSpriteSet(SurvivalReimaginedModParticleTypes.FALLING_WISTERIA_DARK.get(), FallingWisteriaDarkParticle::provider);
		event.registerSpriteSet(SurvivalReimaginedModParticleTypes.BLACK_SMOKE.get(), BlackSmokeParticle::provider);
	}
}