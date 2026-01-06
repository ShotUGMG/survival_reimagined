package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModBlocks;

public class AAFBronzeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:alloy/copper_items")))
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:alloy/tin_items")))
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).is(ItemTags.create(ResourceLocation.parse("c:alloy/copper_items")))
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).is(ItemTags.create(ResourceLocation.parse("c:alloy/tin_items")))) {
			if (2 * YieldMultiplierProcedure.execute(world, x, y, z) + itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() < 64) {
				if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == SurvivalReimaginedModItems.BLOCK_PACKAGING_UPGRADE.get()
						|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == SurvivalReimaginedModItems.BLOCK_PACKAGING_UPGRADE.get()
						|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).copy()).getItem() == SurvivalReimaginedModItems.BLOCK_PACKAGING_UPGRADE.get()
						|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).copy()).getItem() == SurvivalReimaginedModItems.BLOCK_PACKAGING_UPGRADE.get()) {
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == SurvivalReimaginedModBlocks.BLOCK_OF_BRONZE.get().asItem()
							|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == ItemStack.EMPTY.getItem()) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("SmeltTime", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SmeltTime") + 1 * EfficiencyMultiplierProcedure.execute(world, x, y, z)));
								_blockEntity.getPersistentData().putDouble("FuelCapacity", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") - 6 / EfficiencyMultiplierProcedure.execute(world, x, y, z)));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SmeltTime") == 300) {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null) {
									_blockEntity.getPersistentData().putDouble("SmeltTime", 0);
								}
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() + itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount() >= 18) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									int _slotid = 1;
									ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
									_stk.shrink(9);
									_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
								}
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									int _slotid = 2;
									ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
									_stk.shrink(9);
									_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
								}
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModBlocks.BLOCK_OF_BRONZE.get()).copy();
									_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() + 2);
									_itemHandlerModifiable.setStackInSlot(0, _setstack);
								}
							}
						}
					} else {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("SmeltTime", (-1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				} else {
					if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == SurvivalReimaginedModItems.ROUGH_BRONZE.get()
							|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == ItemStack.EMPTY.getItem()) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("SmeltTime", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SmeltTime") + 2 * EfficiencyMultiplierProcedure.execute(world, x, y, z)));
								_blockEntity.getPersistentData().putDouble("FuelCapacity", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") - 4 / EfficiencyMultiplierProcedure.execute(world, x, y, z)));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SmeltTime") == 300) {
							if (!world.isClientSide()) {
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockEntity _blockEntity = world.getBlockEntity(_bp);
								BlockState _bs = world.getBlockState(_bp);
								if (_blockEntity != null) {
									_blockEntity.getPersistentData().putDouble("SmeltTime", 0);
								}
								if (world instanceof Level _level)
									_level.sendBlockUpdated(_bp, _bs, _bs, 3);
							}
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								int _slotid = 1;
								ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
								_stk.shrink(1);
								_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
							}
							if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
								int _slotid = 2;
								ItemStack _stk = _itemHandlerModifiable.getStackInSlot(_slotid).copy();
								_stk.shrink(1);
								_itemHandlerModifiable.setStackInSlot(_slotid, _stk);
							}
							if (YieldMultiplierProcedure.execute(world, x, y, z) > 0) {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.ROUGH_BRONZE.get()).copy();
									_setstack.setCount((int) (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() + 2 * YieldMultiplierProcedure.execute(world, x, y, z)));
									_itemHandlerModifiable.setStackInSlot(0, _setstack);
								}
							} else {
								if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
									ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.ROUGH_BRONZE.get()).copy();
									_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() + 2);
									_itemHandlerModifiable.setStackInSlot(0, _setstack);
								}
							}
						}
					} else {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("SmeltTime", (-1));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
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