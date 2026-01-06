package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class SpoiledCodItem extends Item {
	public SpoiledCodItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(1).saturationModifier(0.1f).build()));
	}
}