package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class DoesNotStackProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getItem() == SurvivalReimaginedModItems.BLOCK_PACKAGING_UPGRADE.get()) {
			return "\u00A77 Does not stack" + "\n" + "\u00A77 Unaffected by Yield Upgrade";
		}
		return "\u00A77 Does not stack";
	}
}