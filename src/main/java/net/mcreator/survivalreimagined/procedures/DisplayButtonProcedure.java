package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.entity.Entity;

public class DisplayButtonProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (RMIWhileThisGUIIsOpenTickProcedure.execute(entity) == true) {
			return true;
		}
		return false;
	}
}
