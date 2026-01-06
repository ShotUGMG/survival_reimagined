package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CuredIntestinesItem extends Item {
	public CuredIntestinesItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(12).saturationModifier(0.7f).build()));
	}
}