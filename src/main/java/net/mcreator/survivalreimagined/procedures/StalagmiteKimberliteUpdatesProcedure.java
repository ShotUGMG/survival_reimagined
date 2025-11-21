package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class StalagmiteKimberliteUpdatesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x + 0.5, y + 1, z + 0.5))).getBlock() == SurvivalReimaginedModBlocks.KIMBERLITE_STALAGMITE_TOP.get()) {
			{
				BlockPos _bp = BlockPos.containing(x + 0.5, y, z + 0.5);
				BlockState _bs = SurvivalReimaginedModBlocks.KIMBERLITE_STALAGMITE_MIDDLE.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if ((world.getBlockState(BlockPos.containing(x + 0.5, y + 1, z + 0.5))).getBlock() == SurvivalReimaginedModBlocks.KIMBERLITE_STALAGMITE_MIDDLE.get()) {
			{
				BlockPos _bp = BlockPos.containing(x + 0.5, y, z + 0.5);
				BlockState _bs = SurvivalReimaginedModBlocks.KIMBERLITE_STALAGMITE_BASE.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		} else if (world.isEmptyBlock(BlockPos.containing(x + 0.5, y + 1, z + 0.5))) {
			{
				BlockPos _bp = BlockPos.containing(x + 0.5, y, z + 0.5);
				BlockState _bs = SurvivalReimaginedModBlocks.KIMBERLITE_STALAGMITE_TOP.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
	}
}
