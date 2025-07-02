package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

import java.util.function.Supplier;
import java.util.Map;

public class DisableRodPickupProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY)
				.getItem() == SurvivalReimaginedModItems.ADVANCED_REACTOR_ROD.get()) {
			return true;
		}
		return false;
	}
}
