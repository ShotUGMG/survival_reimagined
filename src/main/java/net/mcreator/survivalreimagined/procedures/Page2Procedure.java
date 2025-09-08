package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.entity.Entity;

public class Page2Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getDouble("PageNumber") == 2) {
			return true;
		}
		return false;
	}
}
