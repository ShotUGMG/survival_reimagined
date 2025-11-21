
package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AmberItem extends Item {
	public AmberItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
