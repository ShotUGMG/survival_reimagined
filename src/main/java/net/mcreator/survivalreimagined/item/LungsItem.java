package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class LungsItem extends Item {
	public LungsItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.4f).build()));
	}
}