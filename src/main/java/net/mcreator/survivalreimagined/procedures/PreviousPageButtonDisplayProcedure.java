package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.entity.Entity;

public class PreviousPageButtonDisplayProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("PageNumber") < 2) {
			return false;
		}
		return true;
	}
}
