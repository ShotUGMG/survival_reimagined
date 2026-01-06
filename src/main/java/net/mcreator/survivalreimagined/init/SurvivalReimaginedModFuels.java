/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;

@EventBusSubscriber
public class SurvivalReimaginedModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == SurvivalReimaginedModItems.LARGE_OAK_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.LARGE_DARK_OAK_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.LARGE_SPRUCE_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.LARGE_BIRCH_BARK.get())
			event.setBurnTime(600);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.LARGE_MANGROVE_BARK.get())
			event.setBurnTime(600);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.LARGE_CHERRY_BARK.get())
			event.setBurnTime(600);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.LARGE_ACACIA_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.LARGE_JUNGLE_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.SMALL_COAL_CHUNK.get())
			event.setBurnTime(800);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.OAK_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.DARK_OAK_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.SPRUCE_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.BIRCH_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.ACACIA_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.JUNGLE_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.CHERRY_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.MANGROVE_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.WOOD_INGOT.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.FIR_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.PINE_BARK_RU.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.WILLOW_BARK_RU.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.REDWOOD_BARK_RU.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.MAGNOILA_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.KAPOK_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.LARCH_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.EUCALYPTUS_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.CYPRESS_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.SOCOTRA_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.MAUVE_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.MAPLE_BARK_RU.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.DEAD_BARK_RU.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.COBALT_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.BRIMWOOD_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.BAOBAB_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.SILVER_BIRCH_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.ASHEN_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.JOSHUA_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.ALPHA_OAK_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.BLACKWOOD_BARK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.PALM_BARK_RU.get())
			event.setBurnTime(400);
	}
}