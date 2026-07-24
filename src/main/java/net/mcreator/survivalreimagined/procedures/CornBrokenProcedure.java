package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CornBrokenProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
	}

	public static void execute(LevelAccessor world, double x, double y, double z) {
		execute(null, world, x, y, z);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CORN_STALK_TOP.get()) {
			world.destroyBlock(BlockPos.containing(x, y - 1, z), false);
			world.destroyBlock(BlockPos.containing(x, y - 2, z), false);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CORN_STALK_MIDDLE.get()) {
			world.destroyBlock(BlockPos.containing(x, y + 1, z), false);
			world.destroyBlock(BlockPos.containing(x, y - 1, z), false);
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CORN_STALK_BOTTOM.get()) {
			world.destroyBlock(BlockPos.containing(x, y + 1, z), false);
			world.destroyBlock(BlockPos.containing(x, y + 2, z), false);
		}
	}
}