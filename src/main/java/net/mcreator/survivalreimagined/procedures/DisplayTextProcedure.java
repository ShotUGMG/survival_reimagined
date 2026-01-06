package net.mcreator.survivalreimagined.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class DisplayTextProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:compat/incomplete"))) && !ModList.get().isLoaded("biomesoplenty")) {
			return "\u00A74 Requires Biomes 'o' Plenty" + "\n" + "\u00A74 Incomplete Compat";
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:compat/incomplete"))) && ModList.get().isLoaded("biomesoplenty")) {
			return "\u00A74 Incomplete Compat";
		}
		return "\n";
	}
}