/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;

@EventBusSubscriber
public class SurvivalReimaginedModDispenseBehaviors {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			DispenserBlock.registerBehavior(SurvivalReimaginedModItems.MANDARIN_BOAT.get(), new BoatDispenseItemBehavior(SurvivalReimaginedModBoatTypes.MANDARIN_BOAT_TYPE.getValue()));
			DispenserBlock.registerBehavior(SurvivalReimaginedModItems.WISTERIA_BOAT.get(), new BoatDispenseItemBehavior(SurvivalReimaginedModBoatTypes.WISTERIA_BOAT_TYPE.getValue()));
			DispenserBlock.registerBehavior(SurvivalReimaginedModItems.RADIATED_BOAT.get(), new BoatDispenseItemBehavior(SurvivalReimaginedModBoatTypes.RADIATED_BOAT_TYPE.getValue()));
		});
	}
}