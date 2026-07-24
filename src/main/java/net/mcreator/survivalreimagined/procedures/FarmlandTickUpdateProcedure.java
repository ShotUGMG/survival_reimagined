package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class FarmlandTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.getFluidState(BlockPos.containing(x, y, z - 2)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x, y, z - 1)).createLegacyBlock()).getBlock() == Blocks.WATER
				|| (world.getFluidState(BlockPos.containing(x, y, z + 1)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x, y, z + 2)).createLegacyBlock()).getBlock() == Blocks.WATER
				|| (world.getFluidState(BlockPos.containing(x + 2, y, z - 2)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x + 2, y, z - 1)).createLegacyBlock()).getBlock() == Blocks.WATER
				|| (world.getFluidState(BlockPos.containing(x + 2, y, z)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x + 2, y, z + 1)).createLegacyBlock()).getBlock() == Blocks.WATER
				|| (world.getFluidState(BlockPos.containing(x + 2, y, z + 2)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x + 1, y, z - 2)).createLegacyBlock()).getBlock() == Blocks.WATER
				|| (world.getFluidState(BlockPos.containing(x + 1, y, z - 1)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x + 1, y, z)).createLegacyBlock()).getBlock() == Blocks.WATER
				|| (world.getFluidState(BlockPos.containing(x + 1, y, z + 1)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x + 1, y, z + 2)).createLegacyBlock()).getBlock() == Blocks.WATER
				|| (world.getFluidState(BlockPos.containing(x - 1, y, z - 2)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x - 1, y, z - 1)).createLegacyBlock()).getBlock() == Blocks.WATER
				|| (world.getFluidState(BlockPos.containing(x - 1, y, z)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x - 1, y, z + 1)).createLegacyBlock()).getBlock() == Blocks.WATER
				|| (world.getFluidState(BlockPos.containing(x - 1, y, z + 2)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x - 2, y, z - 2)).createLegacyBlock()).getBlock() == Blocks.WATER
				|| (world.getFluidState(BlockPos.containing(x - 2, y, z - 1)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x - 2, y, z)).createLegacyBlock()).getBlock() == Blocks.WATER
				|| (world.getFluidState(BlockPos.containing(x - 2, y, z + 1)).createLegacyBlock()).getBlock() == Blocks.WATER || (world.getFluidState(BlockPos.containing(x - 2, y, z + 2)).createLegacyBlock()).getBlock() == Blocks.WATER) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MoistureClock") >= 5 && (getPropertyByName(blockstate, "moisture") instanceof IntegerProperty _getip50
					? blockstate.getValue(_getip50)
					: -1) < (blockstate.getBlock().getStateDefinition().getProperty("moisture") instanceof IntegerProperty _max52 ? _max52.getPossibleValues().stream().max(Integer::compareTo).get() : -1)) {
				if (Math.random() < 0.5) {
					{
						int _value = (getPropertyByName(blockstate, "moisture") instanceof IntegerProperty _getip54 ? blockstate.getValue(_getip54) : -1) + 1;
						BlockPos _pos = BlockPos.containing(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						if (_bs.getBlock().getStateDefinition().getProperty("moisture") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
							world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("MoistureClock", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MoistureClock") >= 6 && (getPropertyByName(blockstate, "moisture") instanceof IntegerProperty _getip59 ? blockstate.getValue(_getip59) : -1) > 0) {
				{
					int _value = (getPropertyByName(blockstate, "moisture") instanceof IntegerProperty _getip61 ? blockstate.getValue(_getip61) : -1) - 1;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("moisture") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("MoistureClock", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((getPropertyByName(blockstate, "moisture") instanceof IntegerProperty _getip65 ? blockstate.getValue(_getip65) : -1) == 0 && (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR) {
				if (Math.random() < 0.15) {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.LOW_FERTILITY_FARMLAND.get()) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = Blocks.DIRT.defaultBlockState();
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
					} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.MEDIUM_FERTILITY_SOIL.get()) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = SurvivalReimaginedModBlocks.MEDIUM_FERTILITY_DIRT.get().defaultBlockState();
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
					} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == SurvivalReimaginedModBlocks.HIGH_FERTILITY_SOIL.get()) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = SurvivalReimaginedModBlocks.HIGH_FERTILITY_DIRT.get().defaultBlockState();
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
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("MoistureClock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "MoistureClock") + 1));
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "N") > 0 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "P") > 0 && getBlockNBTNumber(world, BlockPos.containing(x, y, z), "K") > 0) {
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:maintains_farmland")))
					&& ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _max85
							? _max85.getPossibleValues().stream().max(Integer::compareTo).get()
							: -1) > (getPropertyByName((world.getBlockState(BlockPos.containing(x, y + 1, z))), "age") instanceof IntegerProperty _getip87 ? (world.getBlockState(BlockPos.containing(x, y + 1, z))).getValue(_getip87) : -1)) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("FertilizerClock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FertilizerClock") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FertilizerClock") >= 600) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("FertilizerClock", 0);
							_blockEntity.getPersistentData().putDouble("NumberGen", (Mth.nextInt(RandomSource.create(), 1, 3)));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "NumberGen") == 1) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("N", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "N") - 1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "NumberGen") == 2) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("P", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "P") - 1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "NumberGen") == 3) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("K", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "K") - 1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
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

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}