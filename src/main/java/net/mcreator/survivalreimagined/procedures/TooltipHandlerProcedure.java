package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;

public class TooltipHandlerProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:campfire/raw"))) && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("PercentageNumber") > 0) {
			return new java.text.DecimalFormat("\u00A77 ##% Cooked").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("PercentageNumber") / 30);
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:campfire/cooked"))) && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("PercentageNumber") > 0) {
			return new java.text.DecimalFormat("\u00A77 ##% Burnt").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("PercentageNumber") / 30);
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:campfire/burnt"))) && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("PercentageNumber") > 0) {
			return new java.text.DecimalFormat("\u00A77 ##% Charred").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("PercentageNumber") / 30);
		}
		return "\n";
	}
}