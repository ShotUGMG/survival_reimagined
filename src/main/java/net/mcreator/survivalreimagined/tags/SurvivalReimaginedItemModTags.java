package net.mcreator.survivalreimagined.tags;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class SurvivalReimaginedItemModTags {
	public static class Items {
		public static final TagKey<Item> MERGEABLE_MEATS = 
		TagKey.create(
			Registries.ITEM, 
			ResourceLocation.fromNamespaceAndPath(
				"survival_reimagined", 
				"mergeable_meats"
			)
		);
	}
}