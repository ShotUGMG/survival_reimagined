package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CuredPorkchopItem extends Item {
	public CuredPorkchopItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(10).saturationModifier(0.6f).build()));
	}
}