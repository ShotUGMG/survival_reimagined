package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.survivalreimagined.entity.BoarEntity;

public class SowBreedProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof BoarEntity == true) {
			return true;
		}
		return false;
	}
}