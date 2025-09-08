package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;

public class MineralProcessingTableBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		MineralProcessingTableOnTickUpdateProcedure.execute(world, x, y, z);
	}
}
