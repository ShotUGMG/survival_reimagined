package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class MPTGUIRedstoneValueProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("redstone_power") instanceof BooleanProperty _getbp1 && (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getbp1)) == true) {
			return "\u00A74Redstone Powered";
		} else if (((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("redstone_power") instanceof BooleanProperty _getbp3
				&& (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getbp3)) == false) {
			return "\u00A74Redstone Unpowered";
		}
		return "\n";
	}
}
