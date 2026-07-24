package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class BananaBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude() == true || world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude() == true || world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude() == true
				|| world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude() == true) {
			return true;
		}
		return false;
	}
}