package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class AppleOakLeavesOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z)) && Math.random() < 0.05) {
			world.setBlock(BlockPos.containing(x, y - 1, z), SurvivalReimaginedModBlocks.APPLE.get().defaultBlockState(), 3);
		}
	}
}