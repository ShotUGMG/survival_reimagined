
package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class RoughAmberItem extends Item {
	public RoughAmberItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
