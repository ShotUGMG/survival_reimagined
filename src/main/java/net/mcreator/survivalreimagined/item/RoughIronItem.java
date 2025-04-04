
package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RoughIronItem extends Item {
	public RoughIronItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
