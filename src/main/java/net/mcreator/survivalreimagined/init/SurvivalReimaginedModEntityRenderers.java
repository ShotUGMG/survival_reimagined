/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.survivalreimagined.client.renderer.*;

@EventBusSubscriber(Dist.CLIENT)
public class SurvivalReimaginedModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(SurvivalReimaginedModEntities.BLOOD_MOON_ZOMBIE.get(), BloodMoonZombieRenderer::new);
		event.registerEntityRenderer(SurvivalReimaginedModEntities.CRIMSON_ARACHNID.get(), CrimsonArachnidRenderer::new);
		event.registerEntityRenderer(SurvivalReimaginedModEntities.ALPHA_CRIMSON_ARACHNID.get(), AlphaCrimsonArachnidRenderer::new);
		event.registerEntityRenderer(SurvivalReimaginedModEntities.BOAR.get(), BoarRenderer::new);
		event.registerEntityRenderer(SurvivalReimaginedModEntities.SOW.get(), SowRenderer::new);
		event.registerEntityRenderer(SurvivalReimaginedModEntities.PIGLET.get(), PigletRenderer::new);
		event.registerEntityRenderer(SurvivalReimaginedModEntities.GHOST.get(), GhostRenderer::new);
	}
}