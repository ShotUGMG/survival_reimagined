
package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class CuredLiverItem extends Item {
	public CuredLiverItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(12).saturationModifier(0.7f).build()));
	}
}
