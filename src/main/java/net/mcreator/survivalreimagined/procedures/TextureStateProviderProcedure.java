package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class TextureStateProviderProcedure {
	public static double execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("c:food/can_rot"))) == true) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpoilageMax") >= 500 && itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpoilageMax") <= 999) {
				return 1;
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpoilageMax") >= 1000
					&& itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpoilageMax") <= 1499) {
				return 2;
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpoilageMax") >= 1500
					&& itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("SpoilageMax") <= 1999) {
				return 3;
			}
		} else if (itemstack.getItem() == SurvivalReimaginedModItems.HIDE.get()) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Drying") == 200) {
				return 1;
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Drying") == 201) {
				return 2;
			}
		}
		return 0;
	}
}