package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModEntities;
import net.mcreator.survivalreimagined.entity.SowEntity;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class BoarBreedProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof SowEntity == true) {
			SurvivalReimaginedMod.queueServerWork(3, () -> {
				for (int index150 = 0; index150 < Mth.nextInt(RandomSource.create(), 1, 4); index150++) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = SurvivalReimaginedModEntities.PIGLET.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			});
			return true;
		}
		return false;
	}
}