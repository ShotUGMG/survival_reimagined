package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class FuelUpgradeDescProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getItem() == SurvivalReimaginedModItems.FUEL_UPGRADE.get()) {
			return "\u00A77 x2 Fuel Capacity" + "\n" + DoesNotStackProcedure.execute(itemstack);
		} else if (itemstack.getItem() == SurvivalReimaginedModItems.FUEL_UPGRADE_MKII.get()) {
			return "\u00A77 x3 Fuel Capacity" + "\n" + DoesNotStackProcedure.execute(itemstack);
		}
		return "\n";
	}
}