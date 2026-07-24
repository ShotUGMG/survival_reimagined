package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class SlotProcessorProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:campfire_cookables")))) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") > 0) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CookSlot1") == 20 * (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("CookSlot1", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("CookSlot1", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CookSlot1") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("CookSlot1", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
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
						if (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("PercentageNumber") == 30) {
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_EQUINE.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_EQUINE.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_EQUINE.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_EQUINE.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_EQUINE.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.POTATO.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(Items.BAKED_POTATO).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == Items.BAKED_POTATO) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_POTATO.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_POTATO.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BEEF.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_BEEF.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_BEEF.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_BEEF.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_BEEF.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_PORKCHOP.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_PORKCHOP.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_PORKCHOP.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_PORKCHOP.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_PORKCHOP.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_CHICKEN.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_CHICKEN.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_CHICKEN.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_CHICKEN.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_CHICKEN.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_RABBIT.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_RABBIT.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_RABBIT.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_RABBIT.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_RABBIT.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_MUTTON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_MUTTON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_MUTTON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_MUTTON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_MUTTON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_COD.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_COD.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_COD.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_COD.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_COD.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_SALMON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_SALMON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_SALMON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_SALMON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_SALMON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.CORN_ON_THE_COB.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_CORN_ON_THE_COB.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_CORN_ON_THE_COB.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_CORN_ON_THE_COB.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_CORN_ON_THE_COB.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							{
								final String _tagName = "PercentageNumber";
								final double _tagValue = 0;
								CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putDouble(_tagName, _tagValue));
							}
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CookSlot1") == 20 * itemstackiterator.getCount()) {
							{
								final String _tagName = "PercentageNumber";
								final double _tagValue = (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("PercentageNumber") + 1);
								CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putDouble(_tagName, _tagValue));
							}
						}
					}
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:campfire_cookables")))) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") > 0) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CookSlot2") == 20 * (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("CookSlot2", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("CookSlot2", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CookSlot2") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("CookSlot2", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (world instanceof ILevelExtension levelExt) {
			IItemHandler handler = levelExt.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null);
			if (handler instanceof IItemHandlerModifiable modifiable) {
				int slotCount = modifiable.getSlots();
				for (int i = 0; i < slotCount; i++) {
					ItemStack itemstackiterator = modifiable.getStackInSlot(i);
					int numberiterator = i;
					if (numberiterator == 2) {
						if (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("PercentageNumber") == 30) {
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_EQUINE.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_EQUINE.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_EQUINE.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_EQUINE.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_EQUINE.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.POTATO.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(Items.BAKED_POTATO).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == Items.BAKED_POTATO) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_POTATO.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_POTATO.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.CORN_ON_THE_COB.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_CORN_ON_THE_COB.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_CORN_ON_THE_COB.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_CORN_ON_THE_COB.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_CORN_ON_THE_COB.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BEEF.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_BEEF.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_BEEF.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_BEEF.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_BEEF.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_PORKCHOP.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_PORKCHOP.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_PORKCHOP.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_PORKCHOP.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_PORKCHOP.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_CHICKEN.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_CHICKEN.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_CHICKEN.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_CHICKEN.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_CHICKEN.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_RABBIT.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_RABBIT.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_RABBIT.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_RABBIT.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_RABBIT.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_MUTTON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_MUTTON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_MUTTON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_MUTTON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_MUTTON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_COD.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_COD.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_COD.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_COD.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_COD.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_SALMON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_SALMON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_SALMON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_SALMON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_SALMON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							{
								final String _tagName = "PercentageNumber";
								final double _tagValue = 0;
								CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putDouble(_tagName, _tagValue));
							}
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CookSlot2") == 20 * itemstackiterator.getCount()) {
							{
								final String _tagName = "PercentageNumber";
								final double _tagValue = (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("PercentageNumber") + 1);
								CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putDouble(_tagName, _tagValue));
							}
						}
					}
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).is(ItemTags.create(ResourceLocation.parse("c:campfire_cookables")))) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") > 0) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CookSlot3") == 20 * (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("CookSlot3", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("CookSlot3", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CookSlot3") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("CookSlot3", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (world instanceof ILevelExtension levelExt) {
			IItemHandler handler = levelExt.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null);
			if (handler instanceof IItemHandlerModifiable modifiable) {
				int slotCount = modifiable.getSlots();
				for (int i = 0; i < slotCount; i++) {
					ItemStack itemstackiterator = modifiable.getStackInSlot(i);
					int numberiterator = i;
					if (numberiterator == 3) {
						if (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("PercentageNumber") == 30) {
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_EQUINE.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_EQUINE.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_EQUINE.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_EQUINE.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_EQUINE.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.POTATO.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(Items.BAKED_POTATO).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == Items.BAKED_POTATO) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_POTATO.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_POTATO.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.CORN_ON_THE_COB.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_CORN_ON_THE_COB.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_CORN_ON_THE_COB.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_CORN_ON_THE_COB.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_CORN_ON_THE_COB.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BEEF.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_BEEF.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_BEEF.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_BEEF.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_BEEF.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_PORKCHOP.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_PORKCHOP.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_PORKCHOP.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_PORKCHOP.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_PORKCHOP.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_CHICKEN.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_CHICKEN.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_CHICKEN.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_CHICKEN.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_CHICKEN.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_RABBIT.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_RABBIT.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_RABBIT.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_RABBIT.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_RABBIT.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_MUTTON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_MUTTON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_MUTTON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_MUTTON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_MUTTON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_COD.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_COD.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_COD.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_COD.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_COD.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_SALMON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_SALMON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_SALMON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_SALMON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_SALMON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							{
								final String _tagName = "PercentageNumber";
								final double _tagValue = 0;
								CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putDouble(_tagName, _tagValue));
							}
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CookSlot3") == 20 * itemstackiterator.getCount()) {
							{
								final String _tagName = "PercentageNumber";
								final double _tagValue = (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("PercentageNumber") + 1);
								CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putDouble(_tagName, _tagValue));
							}
						}
					}
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).is(ItemTags.create(ResourceLocation.parse("c:campfire_cookables")))) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CampfireFuel") > 0) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CookSlot4") == 20 * (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount()) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("CookSlot4", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("CookSlot4", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CookSlot4") + 1));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		} else {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("CookSlot4", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (world instanceof ILevelExtension levelExt) {
			IItemHandler handler = levelExt.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null);
			if (handler instanceof IItemHandlerModifiable modifiable) {
				int slotCount = modifiable.getSlots();
				for (int i = 0; i < slotCount; i++) {
					ItemStack itemstackiterator = modifiable.getStackInSlot(i);
					int numberiterator = i;
					if (numberiterator == 4) {
						if (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("PercentageNumber") == 30) {
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_EQUINE.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_EQUINE.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_EQUINE.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_EQUINE.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_EQUINE.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.POTATO.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(Items.BAKED_POTATO).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == Items.BAKED_POTATO) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_POTATO.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_POTATO.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.CORN_ON_THE_COB.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_CORN_ON_THE_COB.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_CORN_ON_THE_COB.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_CORN_ON_THE_COB.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_CORN_ON_THE_COB.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BEEF.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_BEEF.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_BEEF.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_BEEF.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_BEEF.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_PORKCHOP.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_PORKCHOP.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_PORKCHOP.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_PORKCHOP.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_PORKCHOP.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_CHICKEN.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_CHICKEN.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_CHICKEN.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_CHICKEN.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_CHICKEN.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_RABBIT.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_RABBIT.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_RABBIT.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_RABBIT.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_RABBIT.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_MUTTON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_MUTTON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_MUTTON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_MUTTON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_MUTTON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_COD.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_COD.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_COD.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_COD.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_COD.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.RAW_SALMON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.COOKED_SALMON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.COOKED_SALMON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.BURNT_SALMON.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), (int) numberiterator).copy()).getItem() == SurvivalReimaginedModItems.BURNT_SALMON.get()) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.CHARCOAL_POWDER.get()).copy();
									_setstack.setCount((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getCount());
									_itemHandlerModifiable.setStackInSlot((int) numberiterator, _setstack);
								}
							}
							{
								final String _tagName = "PercentageNumber";
								final double _tagValue = 0;
								CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putDouble(_tagName, _tagValue));
							}
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "CookSlot4") == 20 * itemstackiterator.getCount()) {
							{
								final String _tagName = "PercentageNumber";
								final double _tagValue = (itemstackiterator.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("PercentageNumber") + 1);
								CustomData.update(DataComponents.CUSTOM_DATA, itemstackiterator, tag -> tag.putDouble(_tagName, _tagValue));
							}
						}
					}
				}
			}
		}
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}