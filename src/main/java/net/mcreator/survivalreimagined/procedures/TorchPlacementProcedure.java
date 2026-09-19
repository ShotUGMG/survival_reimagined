package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class TorchPlacementProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CRUDE_TORCH.get() && world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude() == true) {
			return true;
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.CRUDE_WALL_TORCH.get()
				&& (world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude() == true || world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude() == true || world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude() == true
						|| world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude() == true)) {
			return true;
		}
		return false;
	}
}