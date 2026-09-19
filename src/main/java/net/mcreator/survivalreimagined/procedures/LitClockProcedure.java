package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class LitClockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((getPropertyByName(blockstate, "lit") instanceof BooleanProperty _getbp1 && blockstate.getValue(_getbp1)) == true) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("BurnClock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BurnClock") + 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BurnClock") == getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BurnTarget")) {
				if ((getPropertyByName(blockstate, "lit") instanceof BooleanProperty _getbp7 && blockstate.getValue(_getbp7)) == true
						&& ((getPropertyByName(blockstate, "facing") instanceof EnumProperty _getep9 ? blockstate.getValue(_getep9).toString() : "").equals("north")
								|| (getPropertyByName(blockstate, "facing") instanceof EnumProperty _getep11 ? blockstate.getValue(_getep11).toString() : "").equals("south")
								|| (getPropertyByName(blockstate, "facing") instanceof EnumProperty _getep13 ? blockstate.getValue(_getep13).toString() : "").equals("east")
								|| (getPropertyByName(blockstate, "facing") instanceof EnumProperty _getep15 ? blockstate.getValue(_getep15).toString() : "").equals("west"))) {
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = SurvivalReimaginedModBlocks.BURNT_WALL_TORCH.get().defaultBlockState();
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
				} else {
					if ((getPropertyByName(blockstate, "lit") instanceof BooleanProperty _getbp18 && blockstate.getValue(_getbp18)) == true) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = SurvivalReimaginedModBlocks.BURNT_TORCH.get().defaultBlockState();
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
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("BurnClock", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
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

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}