package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class DisplayInfoRunesProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:rune_type/gold")))) {
			return "\u00A77 Rune Type: \u00A76Gold";
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:rune_type/silver")))) {
			return "\u00A77 Rune Type: \u00A7fSilver";
		}
		return "\n";
	}
}