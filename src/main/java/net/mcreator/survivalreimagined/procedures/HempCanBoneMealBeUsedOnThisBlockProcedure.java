package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;

public class HempCanBoneMealBeUsedOnThisBlockProcedure {
	public static boolean execute(BlockState blockstate) {
		if ((blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) < 3) {
			return true;
		}
		return false;
	}
}
