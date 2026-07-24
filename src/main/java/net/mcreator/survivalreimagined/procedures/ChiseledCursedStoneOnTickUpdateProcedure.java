package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class ChiseledCursedStoneOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.CHISELED_CURSED_STONE.get()
				&& !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.CHISELED_CURSED_STONE.get())) {
			{
				int _value = 2;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("state") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.CHISELED_CURSED_STONE.get()
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.CHISELED_CURSED_STONE.get()) {
			{
				int _value = 3;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("state") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if (!((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == SurvivalReimaginedModBlocks.CHISELED_CURSED_STONE.get())
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == SurvivalReimaginedModBlocks.CHISELED_CURSED_STONE.get()) {
			{
				int _value = 1;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("state") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else {
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("state") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
	}
}