package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class PageDisplayHandlerProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == SurvivalReimaginedModItems.AAF_SCRIPTURE.get()) {
			entity.getPersistentData().putDouble("PageNumberMax", 2);
		}
		if (itemstack.getItem() == SurvivalReimaginedModItems.RMI_SCRIPTURE.get()) {
			entity.getPersistentData().putDouble("PageNumberMax", 6);
		}
		if (entity.getPersistentData().getDouble("PageNumber") == 0) {
			entity.getPersistentData().putDouble("PageNumber", 1);
		}
	}
}