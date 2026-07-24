package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class TanningBarrelHandlerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putDouble("BarrelSpriteClock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BarrelSpriteClock") + 1));
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BarrelSpriteClock") == 3) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("BarrelSpriteClock", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			BarrelSpriteIndexHandlerProcedure.execute(world, x, y, z);
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fluid") < 6000 && getBlockNBTLogic(world, BlockPos.containing(x, y, z), "Lime") == false && getBlockNBTLogic(world, BlockPos.containing(x, y, z), "Tannin") == false) {
			if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == Items.WATER_BUCKET) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("Water", true);
						_blockEntity.getPersistentData().putDouble("Fluid", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fluid") + 2000));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(Items.BUCKET).copy();
					_setstack.setCount(1);
					_itemHandlerModifiable.setStackInSlot(0, _setstack);
				}
				SurvivalReimaginedMod.queueServerWork(1, () -> {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.player.splash")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				});
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "Water") == true && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == SurvivalReimaginedModItems.QUICK_LIME.get()) {
			if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() >= (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fluid") / 6000) * 64
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() > 0) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("CanSeal", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BarrelClock") == 24000) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("opened") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("Water", false);
						_blockEntity.getPersistentData().putBoolean("Lime", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.QUICK_LIME.get()).copy();
					_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() - (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fluid") / 6000) * 64));
					_itemHandlerModifiable.setStackInSlot(0, _setstack);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("CanSeal", false);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "Water") == true && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).is(ItemTags.create(ResourceLocation.parse("c:tanning/makes_tannin")))) {
			if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() >= (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fluid") / 6000) * 64
					&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() > 0) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("CanSeal", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BarrelClock") == 24000) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("opened") instanceof BooleanProperty _booleanProp)
						world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("Water", false);
						_blockEntity.getPersistentData().putBoolean("Tannin", true);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).copy();
					_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() - (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fluid") / 6000) * 64));
					_itemHandlerModifiable.setStackInSlot(0, _setstack);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("CanSeal", false);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (world instanceof ILevelExtension levelExt) {
			IItemHandler handler = levelExt.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null);
			if (handler instanceof IItemHandlerModifiable modifiable) {
				int slotCount = modifiable.getSlots();
				for (int i = 0; i < slotCount; i++) {
					ItemStack itemstackiterator = modifiable.getStackInSlot(i);
					int numberiterator = i;
					if (numberiterator == 1) {
						if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "Lime") == true && itemstackiterator.getItem() == SurvivalReimaginedModItems.HIDE.get()
								&& itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Drying") == 200) {
							if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).getCount() <= (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fluid") / 6000) * 6
									&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).getCount() > 0) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putBoolean("CanSeal", true);
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BarrelClock") == 72000) {
								{
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("opened") instanceof BooleanProperty _booleanProp)
										world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putBoolean("CanSeal", false);
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								{
									final String _tagName = "Drying";
									final double _tagValue = 201;
									CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putDouble(_tagName, _tagValue));
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("Fluid",
												(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fluid") - itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).getCount() * 500));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
						} else if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "Tannin") == true && itemstackiterator.getItem() == SurvivalReimaginedModItems.HIDE.get()
								&& itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Drying") == 201) {
							if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).getCount() <= (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fluid") / 6000) * 6
									&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).getCount() > 0) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putBoolean("CanSeal", true);
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BarrelClock") == 72000) {
								{
									BlockPos _pos = BlockPos.containing(x, y, z);
									BlockState _bs = world.getBlockState(_pos);
									if (_bs.getBlock().getStateDefinition().getProperty("opened") instanceof BooleanProperty _booleanProp)
										world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x, y, z);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putBoolean("CanSeal", false);
										_blockEntity.getPersistentData().putDouble("Fluid",
												(getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fluid") - itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).getCount() * 500));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(Items.LEATHER).copy();
									_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).getCount() * 2);
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
						}
					}
				}
			}
		}
		if ((getPropertyByName(blockstate, "opened") instanceof BooleanProperty _getbp97 && blockstate.getValue(_getbp97)) == false) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("BarrelClock", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "BarrelClock") + 1));
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "Water") == true) {
			if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() < (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fluid") / 6000) * 64) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("CanSeal", false);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "Lime") == true || getBlockNBTLogic(world, BlockPos.containing(x, y, z), "Tannin") == true) {
			if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() < (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fluid") / 6000) * 6) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putBoolean("CanSeal", false);
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fluid") <= 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("Water", false);
					_blockEntity.getPersistentData().putBoolean("Lime", false);
					_blockEntity.getPersistentData().putBoolean("Tannin", false);
					_blockEntity.getPersistentData().putBoolean("CanSeal", false);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Fluid") > 6000) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Fluid", 6000);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
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