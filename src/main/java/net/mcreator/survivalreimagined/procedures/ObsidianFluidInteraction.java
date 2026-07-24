package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import net.minecraft.world.level.block.Blocks;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;
import net.neoforged.bus.api.SubscribeEvent;

@EventBusSubscriber
public class ObsidianFluidInteraction {
	@SubscribeEvent
	public static void onFluidPlace(BlockEvent.FluidPlaceBlockEvent event) {
		if (!event.getNewState().is(Blocks.OBSIDIAN))
			return;
		event.setNewState(SurvivalReimaginedModBlocks.BRITTLE_OBSIDIAN.get().defaultBlockState());
	}
}