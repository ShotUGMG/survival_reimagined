package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class AppleOakLeavesOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBrightness(LightLayer.BLOCK, BlockPos.containing(x, y - 1, z)) >= 5 || world.getBrightness(LightLayer.SKY, BlockPos.containing(x, y - 1, z)) >= 5) && world.isEmptyBlock(BlockPos.containing(x, y - 1, z))
				&& Math.random() < 0.025) {
			world.setBlock(BlockPos.containing(x, y - 1, z), (new Object() {
				public BlockState with(BlockState _bs, String _property, int _newValue) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
					return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
				}
			}.with(SurvivalReimaginedModBlocks.APPLE.get().defaultBlockState(), "blockstate", 1)), 3);
		}
	}
}
