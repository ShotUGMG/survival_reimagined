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
					for (int index0 = 0; index0 < 10; index0++) {
						world.addParticle(ParticleTypes.LARGE_SMOKE, (x + Math.random()), y, (z + 1 + Math.random()), 0, 0.2, 0);
					}
				}
			} else if ((getDirectionFromBlockState(blockstate)) == Direction.SOUTH) {
				if (Math.random() < 0.8) {
					for (int index1 = 0; index1 < 10; index1++) {
						world.addParticle(ParticleTypes.LARGE_SMOKE, (x + Math.random()), y, (z - (1 + Math.random())), 0, 0.2, 0);
					}
				}
			} else if ((getDirectionFromBlockState(blockstate)) == Direction.WEST) {
				if (Math.random() < 0.8) {
					for (int index2 = 0; index2 < 10; index2++) {
						world.addParticle(ParticleTypes.LARGE_SMOKE, (x + 1 + Math.random()), y, (z + Math.random()), 0, 0.2, 0);
					}
				}
			} else if ((getDirectionFromBlockState(blockstate)) == Direction.EAST) {
				if (Math.random() < 0.8) {
					for (int index3 = 0; index3 < 10; index3++) {
						world.addParticle(ParticleTypes.LARGE_SMOKE, (x - (1 + Math.random())), y, (z + Math.random()), 0, 0.2, 0);
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
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (prop instanceof DirectionProperty dp)
			return blockState.getValue(dp);
		prop = blockState.getBlock().getStateDefinition().getProperty("axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
	}
}