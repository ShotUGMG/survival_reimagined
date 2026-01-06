package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CuredRabbitItem extends Item {
	public CuredRabbitItem() {
		super(new Item.Properties().food((new FoodProperties.Builder()).nutrition(8).saturationModifier(0.5f).build()));
	}
}