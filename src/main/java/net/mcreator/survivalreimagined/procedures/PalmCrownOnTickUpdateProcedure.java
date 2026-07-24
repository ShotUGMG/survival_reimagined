package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class PalmCrownOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.3) {
			if (Math.random() < 0.25) {
				if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1)) == true) {
					world.setBlock(BlockPos.containing(x, y, z - 1), (blockStateWithDirection((blockStateWithInt(SurvivalReimaginedModBlocks.COCONUT_MATURE.get().defaultBlockState(), "blockstate", 2)), Direction.NORTH)), 3);
				}
			} else if (Math.random() < 0.25) {
				if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1)) == true) {
					world.setBlock(BlockPos.containing(x, y, z + 1), (blockStateWithDirection((blockStateWithInt(SurvivalReimaginedModBlocks.COCONUT_MATURE.get().defaultBlockState(), "blockstate", 2)), Direction.SOUTH)), 3);
				}
			} else if (Math.random() < 0.25) {
				if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z)) == true) {
					world.setBlock(BlockPos.containing(x - 1, y, z), (blockStateWithDirection((blockStateWithInt(SurvivalReimaginedModBlocks.COCONUT_MATURE.get().defaultBlockState(), "blockstate", 2)), Direction.WEST)), 3);
				}
			} else {
				if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z)) == true) {
					world.setBlock(BlockPos.containing(x + 1, y, z), (blockStateWithDirection((blockStateWithInt(SurvivalReimaginedModBlocks.COCONUT_MATURE.get().defaultBlockState(), "blockstate", 2)), Direction.EAST)), 3);
				}
			}
		}
	}

	private static BlockState blockStateWithInt(BlockState blockState, String property, int newValue) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty(property);
		return prop instanceof IntegerProperty ip && prop.getPossibleValues().contains(newValue) ? blockState.setValue(ip, newValue) : blockState;
	}

	private static BlockState blockStateWithDirection(BlockState blockState, Direction newValue) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (prop instanceof DirectionProperty dp && dp.getPossibleValues().contains(newValue))
			return blockState.setValue(dp, newValue);
		prop = blockState.getBlock().getStateDefinition().getProperty("axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().contains(newValue.getAxis()) ? blockState.setValue(ep, newValue.getAxis()) : blockState;
	}
}