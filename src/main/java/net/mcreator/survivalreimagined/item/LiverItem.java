package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class LiverItem extends Item {
	public LiverItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(3).saturationModifier(0.6f).build()));
	}
}