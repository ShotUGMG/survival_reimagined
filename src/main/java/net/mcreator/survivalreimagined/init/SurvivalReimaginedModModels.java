
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.survivalreimagined.client.model.Modeleclipsed_arrow;
import net.mcreator.survivalreimagined.client.model.Modelboat2;
import net.mcreator.survivalreimagined.client.model.ModelGas_Mask_Converted;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class SurvivalReimaginedModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelboat2.LAYER_LOCATION, Modelboat2::createBodyLayer);
		event.registerLayerDefinition(Modeleclipsed_arrow.LAYER_LOCATION, Modeleclipsed_arrow::createBodyLayer);
		event.registerLayerDefinition(ModelGas_Mask_Converted.LAYER_LOCATION, ModelGas_Mask_Converted::createBodyLayer);
	}
}
