package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class FC8Procedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") >= 5250 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") <= 6000) {
			return true;
		}
		return false;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}