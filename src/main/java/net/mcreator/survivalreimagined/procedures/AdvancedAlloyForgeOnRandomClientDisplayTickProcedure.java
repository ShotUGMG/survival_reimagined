package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class AdvancedAlloyForgeOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") > 0) {
			if ((getDirectionFromBlockState(blockstate)) == Direction.NORTH) {
				if (Math.random() < 0.8) {
					for (int index38 = 0; index38 < 10; index38++) {
						world.addParticle(ParticleTypes.LARGE_SMOKE, (x + Math.random()), y, (z + 1 + Math.random()), 0, 0.2, 0);
					}
				}
			} else if ((getDirectionFromBlockState(blockstate)) == Direction.SOUTH) {
				if (Math.random() < 0.8) {
					for (int index39 = 0; index39 < 10; index39++) {
						world.addParticle(ParticleTypes.LARGE_SMOKE, (x + Math.random()), y, (z - Math.random()), 0, 0.2, 0);
					}
				}
			} else if ((getDirectionFromBlockState(blockstate)) == Direction.WEST) {
				if (Math.random() < 0.8) {
					for (int index40 = 0; index40 < 10; index40++) {
						world.addParticle(ParticleTypes.LARGE_SMOKE, (x + 1 + Math.random()), y, (z + Math.random()), 0, 0.2, 0);
					}
				}
			} else if ((getDirectionFromBlockState(blockstate)) == Direction.EAST) {
				if (Math.random() < 0.8) {
					for (int index41 = 0; index41 < 10; index41++) {
						world.addParticle(ParticleTypes.LARGE_SMOKE, (x - Math.random()), y, (z + Math.random()), 0, 0.2, 0);
					}
				}
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		Property<?> prop = getPropertyByName(blockState, "facing");
		if (prop instanceof DirectionProperty dp)
			return blockState.getValue(dp);
		prop = getPropertyByName(blockState, "axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
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