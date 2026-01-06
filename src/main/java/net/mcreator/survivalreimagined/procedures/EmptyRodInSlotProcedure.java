package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class EmptyRodInSlotProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == SurvivalReimaginedModItems.DEPLETED_REACTOR_ROD.get()) {
			return false;
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == SurvivalReimaginedModItems.REACTOR_ROD.get()) {
			return true;
		}
		return true;
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