
package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class EmbeddedDiamondItem extends Item {
	public EmbeddedDiamondItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
