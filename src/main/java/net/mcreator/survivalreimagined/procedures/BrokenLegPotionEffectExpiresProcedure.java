package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.entity.Entity;

public class BrokenLegPotionEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putBoolean("Splint", false);
	}
}