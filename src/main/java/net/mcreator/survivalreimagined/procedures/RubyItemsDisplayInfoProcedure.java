package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class RubyItemsDisplayInfoProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getItem() == SurvivalReimaginedModItems.RUBY_HEART.get()) {
			return "\u00A77 Grants one additional heart. Max of 20";
		} else if (itemstack.getItem() == SurvivalReimaginedModItems.GOLD_HEART.get()) {
			return "\u00A77 Grants immunity to Zombification";
		}
		return "\n";
	}
}