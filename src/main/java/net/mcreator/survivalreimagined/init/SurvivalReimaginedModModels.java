/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.survivalreimagined.client.model.*;

@EventBusSubscriber(Dist.CLIENT)
public class SurvivalReimaginedModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelboat2.LAYER_LOCATION, Modelboat2::createBodyLayer);
		event.registerLayerDefinition(Modeleclipsed_arrow.LAYER_LOCATION, Modeleclipsed_arrow::createBodyLayer);
		event.registerLayerDefinition(ModelCustomModel.LAYER_LOCATION, ModelCustomModel::createBodyLayer);
		event.registerLayerDefinition(Modelpiglet.LAYER_LOCATION, Modelpiglet::createBodyLayer);
		event.registerLayerDefinition(Modelleaves.LAYER_LOCATION, Modelleaves::createBodyLayer);
		event.registerLayerDefinition(Modelsow.LAYER_LOCATION, Modelsow::createBodyLayer);
		event.registerLayerDefinition(Modelghost.LAYER_LOCATION, Modelghost::createBodyLayer);
		event.registerLayerDefinition(Modelboar.LAYER_LOCATION, Modelboar::createBodyLayer);
		event.registerLayerDefinition(ModelGas_Mask_Converted.LAYER_LOCATION, ModelGas_Mask_Converted::createBodyLayer);
	}
}