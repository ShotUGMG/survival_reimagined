package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.ItemStack;

public class EfficiencyDescProcedure {
	public static String execute(ItemStack itemstack) {
		return "\u00A77 Decreases fuel consumption" + "\n" + "\u00A77 Increases smelt time" + "\n" + DoesNotStackProcedure.execute(itemstack);
	}
}
