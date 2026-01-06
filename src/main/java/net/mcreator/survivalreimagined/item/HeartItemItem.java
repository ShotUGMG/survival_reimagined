package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class HeartItemItem extends Item {
	public HeartItemItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).build()));
	}
}