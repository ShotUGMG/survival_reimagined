package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class CampfireSpriteHandlerProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") >= 0 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") <= 40) {
			return 0;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") >= 41 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") <= 80) {
			return 1;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") >= 81 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") <= 120) {
			return 2;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") >= 121 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") <= 160) {
			return 3;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") >= 161 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") <= 200) {
			return 4;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") >= 201 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") <= 240) {
			return 5;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") >= 241 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") <= 280) {
			return 6;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") >= 281 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") <= 320) {
			return 7;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") >= 321 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") <= 360) {
			return 8;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") >= 361 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") <= 400) {
			return 9;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") >= 401 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") <= 440) {
			return 10;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") >= 441 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") <= 480) {
			return 11;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") >= 481 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") <= 520) {
			return 12;
		} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") >= 521 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") <= 560) {
			return 13;
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