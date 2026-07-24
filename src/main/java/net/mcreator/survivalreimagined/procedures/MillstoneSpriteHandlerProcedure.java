package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class MillstoneSpriteHandlerProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Milling") == 1) {
			return 1;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Milling") == 2) {
			return 2;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Milling") == 3) {
			return 3;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Milling") == 4) {
			return 4;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Milling") == 5) {
			return 5;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Milling") == 6) {
			return 6;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Milling") == 7) {
			return 7;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Milling") == 8) {
			return 8;
		}
		return 0;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}