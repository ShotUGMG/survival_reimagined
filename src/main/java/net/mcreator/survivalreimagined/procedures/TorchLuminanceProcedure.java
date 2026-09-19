package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;

public class TorchLuminanceProcedure {
	public static double execute(BlockState blockstate) {
		if ((getPropertyByName(blockstate, "lit") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) == true) {
			return 14;
		} else if ((getPropertyByName(blockstate, "lit") instanceof BooleanProperty _getbp3 && blockstate.getValue(_getbp3)) == false) {
			return 0;
		}
		return 0;
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}