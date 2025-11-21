package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class RockInfoProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/iron"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/iron_nuggets")))) {
			return "\u00A77Iron";
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/copper"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/copper_nuggets")))) {
			return "\u00A77Copper";
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/tin"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/tin_nuggets")))) {
			return "\u00A77Tin";
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/silver"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/silver_nuggets")))) {
			return "\u00A77Silver";
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/uranium"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/uranium_nuggets")))) {
			return "\u00A77Uranium";
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/gold"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/gold_nuggets")))) {
			return "\u00A77Gold";
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/manganese"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/manganese_nuggets")))) {
			return "\u00A77Manganese";
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/titanium"))) || itemstack.is(ItemTags.create(ResourceLocation.parse("c:metal_rocks/titanium_nuggets")))) {
			return "\u00A77Titanium";
		}
		return "\n";
	}
}
