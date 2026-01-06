package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class YieldMultiplierProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double YieldMultiplier = 0;
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).copy()).getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).copy()).getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE.get()) {
			YieldMultiplier = 2;
			return YieldMultiplier;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE_MKII.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE_MKII.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).copy()).getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE_MKII.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).copy()).getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE_MKII.get()) {
			YieldMultiplier = 3;
			return YieldMultiplier;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE_MKIII.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).copy()).getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE_MKIII.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 6).copy()).getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE_MKIII.get()
				^ (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 7).copy()).getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE_MKIII.get()) {
			YieldMultiplier = 4;
			return YieldMultiplier;
		}
		return 1;
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