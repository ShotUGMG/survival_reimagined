package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class GrowBananaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (SurvivalReimaginedModVariables.WorldVariables.get(world).FruitTree == 299) {
			SurvivalReimaginedMod.queueServerWork(1, () -> {
				if (Math.random() < 0.3) {
					if (Math.random() < 0.25) {
						if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1)) == true) {
							world.setBlock(BlockPos.containing(x, y, z - 1), (blockStateWithDirection(SurvivalReimaginedModBlocks.BANANA_CLUSTER.get().defaultBlockState(), Direction.NORTH)), 3);
						}
					} else if (Math.random() < 0.25) {
						if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1)) == true) {
							world.setBlock(BlockPos.containing(x, y, z + 1), (blockStateWithDirection(SurvivalReimaginedModBlocks.BANANA_CLUSTER.get().defaultBlockState(), Direction.SOUTH)), 3);
						}
					} else if (Math.random() < 0.25) {
						if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z)) == true) {
							world.setBlock(BlockPos.containing(x - 1, y, z), (blockStateWithDirection(SurvivalReimaginedModBlocks.BANANA_CLUSTER.get().defaultBlockState(), Direction.WEST)), 3);
						}
					} else {
						if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z)) == true) {
							world.setBlock(BlockPos.containing(x + 1, y, z), (blockStateWithDirection(SurvivalReimaginedModBlocks.BANANA_CLUSTER.get().defaultBlockState(), Direction.EAST)), 3);
						}
					}
				}
			});
		}
	}

	private static BlockState blockStateWithDirection(BlockState blockState, Direction newValue) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (prop instanceof DirectionProperty dp && dp.getPossibleValues().contains(newValue))
			return blockState.setValue(dp, newValue);
		prop = blockState.getBlock().getStateDefinition().getProperty("axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().contains(newValue.getAxis()) ? blockState.setValue(ep, newValue.getAxis()) : blockState;
	}
}