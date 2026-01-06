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
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class FuelManagementProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double FuelLock = 0;
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == SurvivalReimaginedModItems.FUEL_UPGRADE_MKII.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == SurvivalReimaginedModItems.FUEL_UPGRADE_MKII.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).copy()).getItem() == SurvivalReimaginedModItems.FUEL_UPGRADE_MKII.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).copy()).getItem() == SurvivalReimaginedModItems.FUEL_UPGRADE_MKII.get()) {
			FuelLock = 9000;
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("FuelUpgrade", 2);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == SurvivalReimaginedModItems.FUEL_UPGRADE.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == SurvivalReimaginedModItems.FUEL_UPGRADE.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).copy()).getItem() == SurvivalReimaginedModItems.FUEL_UPGRADE.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).copy()).getItem() == SurvivalReimaginedModItems.FUEL_UPGRADE.get()) {
			FuelLock = 6000;
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("FuelUpgrade", 1);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else {
			FuelLock = 3000;
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("FuelUpgrade", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") > FuelLock) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("FuelCapacity", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") - 3000));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == SurvivalReimaginedModItems.ADVANCED_REACTOR_ROD.get()) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") < FuelLock) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("FuelCapacity", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") + 10));
						_blockEntity.getPersistentData().putDouble("FuelTimer", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelTimer") + 10));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelTimer") == 3000) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.DRAINED_ADVANCED_REACTOR_ROD.get()).copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(3, _setstack);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("FuelTimer", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == SurvivalReimaginedModItems.REACTOR_ROD.get()) {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") < FuelLock) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null) {
						_blockEntity.getPersistentData().putDouble("FuelCapacity", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") + 10));
						_blockEntity.getPersistentData().putDouble("FuelTimer", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelTimer") + 10));
					}
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelTimer") == 1500) {
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						ItemStack _setstack = new ItemStack(SurvivalReimaginedModItems.DEPLETED_REACTOR_ROD.get()).copy();
						_setstack.setCount(1);
						_itemHandlerModifiable.setStackInSlot(3, _setstack);
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("FuelTimer", 0);
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") < 0) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("FuelCapacity", 0);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
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