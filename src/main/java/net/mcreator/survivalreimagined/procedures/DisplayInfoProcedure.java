package net.mcreator.survivalreimagined.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class DisplayInfoProcedure {
	public static String execute(ItemStack itemstack) {
		double Count = 0;
		if (ModList.get().isLoaded("jei")) {
			if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:components/sword_blade"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("c:components/hoe_blade")))
					|| itemstack.is(ItemTags.create(ResourceLocation.parse("c:components/saw_blade")))) {
				Count = 2;
				return "\u00A77 Requires " + Math.round(Count) + "\u00A77 Ingots in the Forge";
			} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:components/pickaxe_head"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("c:components/axe_head")))
					|| itemstack.is(ItemTags.create(ResourceLocation.parse("c:components/hammer_head")))) {
				Count = 3;
				return "\u00A77 Requires " + Math.round(Count) + "\u00A77 Ingots in the Forge";
			} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:components/knife_blade"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("c:components/shovel_head")))) {
				Count = 1;
				return "\u00A77 Requires " + Math.round(Count) + "\u00A77 Ingots in the Forge";
			} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:components/helmet")))) {
				Count = 5;
				return "\u00A77 Requires " + Math.round(Count) + "\u00A77 Ingots in the Forge";
			} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:components/chestplate")))) {
				Count = 8;
				return "\u00A77 Requires " + Math.round(Count) + "\u00A77 Ingots in the Forge";
			} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:components/legs")))) {
				Count = 7;
				return "\u00A77 Requires " + Math.round(Count) + "\u00A77 Ingots in the Forge";
			} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:components/boots")))) {
				Count = 4;
				return "\u00A77 Requires " + Math.round(Count) + "\u00A77 Ingots in the Forge";
			}
		}
		return "\n";
	}
}
