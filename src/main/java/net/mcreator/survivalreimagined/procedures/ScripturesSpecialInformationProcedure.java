package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.ItemStack;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class ScripturesSpecialInformationProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getItem() == SurvivalReimaginedModItems.AAF_SCRIPTURE.get()) {
			return "\u00A77 Advanced Alloy Forge";
		} else if (itemstack.getItem() == SurvivalReimaginedModItems.RMI_SCRIPTURE.get()) {
			return "\u00A77 Rune Magic Infuser";
		}
		return "\n";
	}
}