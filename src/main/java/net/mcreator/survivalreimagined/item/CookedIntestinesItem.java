package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CookedIntestinesItem extends Item {
	public CookedIntestinesItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(10).saturationModifier(1f).build()));
	}
}