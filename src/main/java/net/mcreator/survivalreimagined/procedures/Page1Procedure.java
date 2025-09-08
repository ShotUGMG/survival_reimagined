package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.entity.Entity;

public class Page1Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("PageNumber") == 1) {
			return true;
		}
		return false;
	}
}
