
package net.mcreator.survivalreimagined.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class BloodMoonsMusicDiscItem extends Item {
	public BloodMoonsMusicDiscItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.RARE).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(SurvivalReimaginedMod.MODID, "blood_moons_music_disc"))));
	}
}
