package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.survivalreimagined.entity.AlphaCrimsonArachnidEntity;

public class AlphaCrimsonArachnidThisEntityKillsAnotherOneProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof AlphaCrimsonArachnidEntity) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.setHealth(30);
		}
	}
}
