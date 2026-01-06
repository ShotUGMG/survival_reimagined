package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class ThinRadiatedVinesOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world.isEmptyBlock(BlockPos.containing(x, y - 1, z))) {
			if (Math.random() < 0.15) {
				world.setBlock(BlockPos.containing(x, y - 1, z), SurvivalReimaginedModBlocks.THIN_RADIATED_VINES.get().defaultBlockState(), 3);
				if (world instanceof Level _level)
					_level.updateNeighborsAt(BlockPos.containing(x, y, z), _level.getBlockState(BlockPos.containing(x, y, z)).getBlock());
			}
		}
	}
}