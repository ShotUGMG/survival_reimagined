package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMenus;

public class MPTTooltipDisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof SurvivalReimaginedModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem())) {
			return true;
		}
		return false;
	}
}