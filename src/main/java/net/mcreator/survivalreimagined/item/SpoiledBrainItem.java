package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class SpoiledBrainItem extends Item {
	public SpoiledBrainItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationModifier(0.1f).build()));
	}
}