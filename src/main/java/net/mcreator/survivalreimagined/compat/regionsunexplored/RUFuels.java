package net.mcreator.survivalreimagined.compat.regionsunexplored;

import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

@EventBusSubscriber
public class RUFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == SurvivalReimaginedModItems.ALPHA_OAK_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.BAOBAB_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.BLACKWOOD_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.BRIMWOOD_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.COBALT_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.CYPRESS_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.DEAD_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.EUCALYPTUS_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.JOSHUA_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.KAPOK_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.LARCH_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.MAGNOLIA_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.MAPLE_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.MAUVE_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.PALM_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.PINE_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.REDWOOD_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.SOCOTRA_PLANK.get())
			event.setBurnTime(400);
		else if (itemstack.getItem() == SurvivalReimaginedModItems.WILLOW_PLANK.get())
			event.setBurnTime(400);
	}
}