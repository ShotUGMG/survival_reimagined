package net.mcreator.survivalreimagined.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

import java.util.Comparator;

public class GrowingProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (ModList.get().isLoaded("sereneseasons") == true) {
			if ((GetCurrentSeasonProcedure.execute(world)).equals("Spring") && (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("sereneseasons:spring_crops")))) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("GrowClockMaxSpring", 100);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("GrowClockMaxSpring", 400);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((GetCurrentSeasonProcedure.execute(world)).equals("Summer") && (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("sereneseasons:summer_crops")))) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("GrowClockMaxSummer", 100);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("GrowClockMaxSummer", 400);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((GetCurrentSeasonProcedure.execute(world)).equals("Autumn") && (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("sereneseasons:autumn_crops")))) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("GrowClockMaxAutumn", 100);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("GrowClockMaxAutumn", 400);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((GetCurrentSeasonProcedure.execute(world)).equals("Winter") && (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("sereneseasons:winter_crops")))) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("GrowClockMaxWinter", 100);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("GrowClockMaxWinter", 400);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else if (ModList.get().isLoaded("sereneseasons") == false || (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("sereneseasons:year_round_crops")))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("GrowClockMax", 200);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("c:soil")))) {
			if ((getPropertyByName(blockstate, "age") instanceof IntegerProperty _getip25 ? blockstate.getValue(_getip25) : -1) < (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _max27
					? _max27.getPossibleValues().stream().max(Integer::compareTo).get()
					: -1)
					&& getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "N") > 0 && getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "P") > 0 && getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "K") > 0
					&& ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock().getStateDefinition().getProperty("moisture") instanceof IntegerProperty _max32
							? _max32.getPossibleValues().stream().max(Integer::compareTo).get()
							: -1) <= 7) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("GrowClock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GrowClock") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:fruit_of_tree")))
				|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:berry_bush")))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("GrowClock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GrowClock") + 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (ModList.get().isLoaded("sereneseasons") == true) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GrowClock") > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GrowClockMaxSpring")
					|| getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GrowClock") > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GrowClockMaxSummer")
					|| getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GrowClock") > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GrowClockMaxAutumn")
					|| getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GrowClock") > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GrowClockMaxWinter")
					|| getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GrowClock") > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GrowClockMax")) {
				if (Math.random() < 0.45) {
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						{
							int _value = (getPropertyByName(blockstate, "age") instanceof IntegerProperty _getip54 ? blockstate.getValue(_getip54) : -1) + 1;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					});
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("GrowClock", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("GrowClock", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else if (ModList.get().isLoaded("sereneseasons") == false) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GrowClock") > getBlockNBTNumber(world, BlockPos.containing(x, y, z), "GrowClockMax")) {
				if (Math.random() < 0.45) {
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						{
							int _value = (getPropertyByName(blockstate, "age") instanceof IntegerProperty _getip63 ? blockstate.getValue(_getip63) : -1) + 1;
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
								world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
						}
					});
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("GrowClock", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("GrowClock", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))) == (blockStateWithInt(SurvivalReimaginedModBlocks.CORN_STALK_BOTTOM.get().defaultBlockState(), "age", 4)) && world.isEmptyBlock(BlockPos.containing(x, y + 1, z)) == true) {
			world.setBlock(BlockPos.containing(x, y + 1, z), SurvivalReimaginedModBlocks.CORN_STALK_MIDDLE.get().defaultBlockState(), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))) == (blockStateWithInt(SurvivalReimaginedModBlocks.CORN_STALK_BOTTOM.get().defaultBlockState(), "age", 7)) && world.isEmptyBlock(BlockPos.containing(x, y + 2, z)) == true) {
			world.setBlock(BlockPos.containing(x, y + 2, z), SurvivalReimaginedModBlocks.CORN_STALK_TOP.get().defaultBlockState(), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))) == (blockStateWithInt(SurvivalReimaginedModBlocks.CORN_STALK_BOTTOM.get().defaultBlockState(), "age", 5))) {
			{
				int _value = 1;
				BlockPos _pos = BlockPos.containing(x, y + 1, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))) == (blockStateWithInt(SurvivalReimaginedModBlocks.CORN_STALK_BOTTOM.get().defaultBlockState(), "age", 6))) {
			{
				int _value = 2;
				BlockPos _pos = BlockPos.containing(x, y + 1, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))) == (blockStateWithInt(SurvivalReimaginedModBlocks.CORN_STALK_BOTTOM.get().defaultBlockState(), "age", 7))) {
			{
				int _value = 3;
				BlockPos _pos = BlockPos.containing(x, y + 1, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))) == (blockStateWithInt(SurvivalReimaginedModBlocks.CORN_STALK_BOTTOM.get().defaultBlockState(), "age", 8))) {
			{
				int _value = 4;
				BlockPos _pos = BlockPos.containing(x, y + 1, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			{
				int _value = 1;
				BlockPos _pos = BlockPos.containing(x, y + 2, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))) == (blockStateWithInt(SurvivalReimaginedModBlocks.CORN_STALK_BOTTOM.get().defaultBlockState(), "age", 9))) {
			{
				int _value = 5;
				BlockPos _pos = BlockPos.containing(x, y + 1, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			{
				int _value = 2;
				BlockPos _pos = BlockPos.containing(x, y + 2, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))) == (blockStateWithInt(SurvivalReimaginedModBlocks.CORN_STALK_BOTTOM.get().defaultBlockState(), "age", 10))) {
			{
				int _value = 6;
				BlockPos _pos = BlockPos.containing(x, y + 1, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			{
				int _value = 3;
				BlockPos _pos = BlockPos.containing(x, y + 2, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))) == (blockStateWithInt(SurvivalReimaginedModBlocks.CORN_STALK_BOTTOM.get().defaultBlockState(), "age", 11))) {
			{
				int _value = 7;
				BlockPos _pos = BlockPos.containing(x, y + 1, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			{
				int _value = 4;
				BlockPos _pos = BlockPos.containing(x, y + 2, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:maintains_farmland")))) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "N") <= 0 || getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "P") <= 0 || getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "K") <= 0) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y - 1, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("DeathClock", (getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "DeathClock") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			} else {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y - 1, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("DeathClock", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y - 1, z), "DeathClock") >= 2000) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y - 1, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("DeathClock", 0);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				{
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockState _bs = Blocks.DEAD_BUSH.defaultBlockState();
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
				{
					final Vec3 _center = new Vec3(x, y, z);
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof ServerPlayer == true) {
							if (entityiterator instanceof ServerPlayer _player) {
								AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("survival_reimagined:terrible_farmer"));
								if (_adv != null) {
									AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
									if (!_ap.isDone()) {
										for (String criteria : _ap.getRemainingCriteria())
											_player.getAdvancements().award(_adv, criteria);
									}
								}
							}
						}
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("survival_reimagined:corn")))
						&& (world.getBlockState(BlockPos.containing(x, y + 2, z))).is(BlockTags.create(ResourceLocation.parse("survival_reimagined:corn")))) {
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
					world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
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

	private static BlockState blockStateWithInt(BlockState blockState, String property, int newValue) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty(property);
		return prop instanceof IntegerProperty ip && prop.getPossibleValues().contains(newValue) ? blockState.setValue(ip, newValue) : blockState;
	}
}