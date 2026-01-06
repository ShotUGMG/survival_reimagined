package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMenus;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

public class DisableRodPickupProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(3).getItem() : ItemStack.EMPTY)
				.getItem() == SurvivalReimaginedModItems.ADVANCED_REACTOR_ROD.get()) {
			return true;
		}
		return false;
	}
}