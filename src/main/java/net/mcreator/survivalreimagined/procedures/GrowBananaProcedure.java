package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class GrowBananaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.random() < 0.05) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "NumberGen") == 1) {
				if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1)) == true) {
					world.setBlock(BlockPos.containing(x, y, z - 1), (blockStateWithDirection(SurvivalReimaginedModBlocks.BANANA_CLUSTER.get().defaultBlockState(), Direction.NORTH)), 3);
				}
			} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "NumberGen") == 2) {
				if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1)) == true) {
					world.setBlock(BlockPos.containing(x, y, z + 1), (blockStateWithDirection(SurvivalReimaginedModBlocks.BANANA_CLUSTER.get().defaultBlockState(), Direction.SOUTH)), 3);
				}
			} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "NumberGen") == 3) {
				if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z)) == true) {
					world.setBlock(BlockPos.containing(x - 1, y, z), (blockStateWithDirection(SurvivalReimaginedModBlocks.BANANA_CLUSTER.get().defaultBlockState(), Direction.WEST)), 3);
				}
			} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "NumberGen") == 4) {
				if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z)) == true) {
					world.setBlock(BlockPos.containing(x + 1, y, z), (blockStateWithDirection(SurvivalReimaginedModBlocks.BANANA_CLUSTER.get().defaultBlockState(), Direction.EAST)), 3);
				}
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("NumberGen", (Mth.nextInt(RandomSource.create(), 1, 4)));
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static BlockState blockStateWithDirection(BlockState blockState, Direction newValue) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (prop instanceof DirectionProperty dp && dp.getPossibleValues().contains(newValue))
			return blockState.setValue(dp, newValue);
		prop = blockState.getBlock().getStateDefinition().getProperty("axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().contains(newValue.getAxis()) ? blockState.setValue(ep, newValue.getAxis()) : blockState;
	}
}