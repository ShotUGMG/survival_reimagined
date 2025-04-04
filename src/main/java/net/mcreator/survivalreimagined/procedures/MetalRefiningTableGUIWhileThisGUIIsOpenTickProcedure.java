package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

public class MetalRefiningTableGUIWhileThisGUIIsOpenTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			((Slot) _slots.get(2)).remove(1);
			_player.containerMenu.broadcastChanges();
		}
		IronRecipeProcedure.execute(entity);
		BronzeGearRecipesProcedure.execute(entity);
		SteelGearRecipesProcedure.execute(entity);
		DiamondGearRecipesProcedure.execute(entity);
	}
}
