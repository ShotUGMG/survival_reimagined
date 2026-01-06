package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class AdvancedAlloyForgeOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		FuelManagementProcedure.execute(world, x, y, z);
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") > 0) {
			AAFRecipesProcedure.execute(world, x, y, z);
		} else {
			if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") == 0) {
				if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SmeltTime") > 0) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null) {
							_blockEntity.getPersistentData().putDouble("SmeltTime", (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "SmeltTime") - 2));
						}
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			} else if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "FuelCapacity") < 0) {
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
			}
		}
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == ItemStack.EMPTY.getItem() || (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == ItemStack.EMPTY.getItem()) {
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
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}