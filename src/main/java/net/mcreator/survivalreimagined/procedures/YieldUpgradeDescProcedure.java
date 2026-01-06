package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class YieldUpgradeDescProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE.get()) {
			return "\u00A77 x2 Smelt Yield" + "\n" + DoesNotStackProcedure.execute(itemstack);
		} else if (itemstack.getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE_MKII.get()) {
			return "\u00A77 x3 Smelt Yield" + "\n" + DoesNotStackProcedure.execute(itemstack);
		} else if (itemstack.getItem() == SurvivalReimaginedModItems.YIELD_UPGRADE_MKIII.get()) {
			return "\u00A77 x4 Smelt Yield" + "\n" + DoesNotStackProcedure.execute(itemstack);
		}
		return "\n";
	}
}