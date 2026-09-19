package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;

public class TorchParticlesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((getPropertyByName(blockstate, "lit") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) == true
				&& (getPropertyByName(blockstate, "facing") instanceof EnumProperty _getep3 ? blockstate.getValue(_getep3).toString() : "").equals("north")) {
			world.addParticle(ParticleTypes.FLAME, (x + 0.5), (y + 0.9), (z + 0.75), 0, 0, 0);
			world.addParticle(ParticleTypes.SMOKE, (x + 0.5), (y + 0.9), (z + 0.75), 0, 0.05, 0);
		} else if ((getPropertyByName(blockstate, "lit") instanceof BooleanProperty _getbp7 && blockstate.getValue(_getbp7)) == true
				&& (getPropertyByName(blockstate, "facing") instanceof EnumProperty _getep9 ? blockstate.getValue(_getep9).toString() : "").equals("south")) {
			world.addParticle(ParticleTypes.FLAME, (x + 0.5), (y + 0.9), (z + 0.25), 0, 0, 0);
			world.addParticle(ParticleTypes.SMOKE, (x + 0.5), (y + 0.9), (z + 0.25), 0, 0.05, 0);
		} else if ((getPropertyByName(blockstate, "lit") instanceof BooleanProperty _getbp13 && blockstate.getValue(_getbp13)) == true
				&& (getPropertyByName(blockstate, "facing") instanceof EnumProperty _getep15 ? blockstate.getValue(_getep15).toString() : "").equals("west")) {
			world.addParticle(ParticleTypes.FLAME, (x + 0.75), (y + 0.9), (z + 0.5), 0, 0, 0);
			world.addParticle(ParticleTypes.FLAME, (x + 0.75), (y + 0.9), (z + 0.5), 0, 0, 0);
		} else if ((getPropertyByName(blockstate, "lit") instanceof BooleanProperty _getbp19 && blockstate.getValue(_getbp19)) == true
				&& (getPropertyByName(blockstate, "facing") instanceof EnumProperty _getep21 ? blockstate.getValue(_getep21).toString() : "").equals("east")) {
			world.addParticle(ParticleTypes.SMOKE, (x + 0.25), (y + 0.9), (z + 0.5), 0, 0.05, 0);
			world.addParticle(ParticleTypes.FLAME, (x + 0.25), (y + 0.9), (z + 0.5), 0, 0, 0);
		} else {
			if ((getPropertyByName(blockstate, "lit") instanceof BooleanProperty _getbp25 && blockstate.getValue(_getbp25)) == true) {
				world.addParticle(ParticleTypes.FLAME, (x + 0.5), (y + 0.7), (z + 0.5), 0, 0, 0);
				world.addParticle(ParticleTypes.SMOKE, (x + 0.5), (y + 0.7), (z + 0.5), 0, 0.05, 0);
			}
		}
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