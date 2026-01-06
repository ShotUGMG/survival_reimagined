package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CookedHeartItem extends Item {
	public CookedHeartItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(10).saturationModifier(1f).build()));
	}
}