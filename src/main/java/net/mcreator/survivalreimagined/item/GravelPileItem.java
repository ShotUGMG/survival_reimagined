
package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class GravelPileItem extends Item {
	public GravelPileItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
