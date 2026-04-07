package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModEntities;
import net.mcreator.survivalreimagined.entity.SowEntity;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

import java.util.Comparator;

public class PigletFollowMotherProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean Found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		Found = Found;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (!world.getEntitiesOfClass(SowEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(4 / 2d), e -> true).isEmpty() == false) {
					if ((findEntityInWorldRange(world, SowEntity.class, x, y, z, 20)) == entityiterator) {
						if (entity instanceof Mob _entity)
							_entity.getNavigation().moveTo((entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 1);
						Found = true;
					} else {
						Found = false;
					}
				}
			}
		}
		entity.getPersistentData().putDouble("GrowUpClock", (entity.getPersistentData().getDouble("GrowUpClock") + 1));
		if (entity.getPersistentData().getDouble("GrowUpClock") == 3000) {
			entity.getPersistentData().putDouble("GrowUpClock", 0);
			if (entity.getPersistentData().getDouble("PortionsEaten") > 3) {
				if (Math.random() > 0.3) {
					if (Math.random() > 0.3) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = SurvivalReimaginedModEntities.BOAR.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = SurvivalReimaginedModEntities.SOW.get().spawn(_level, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), MobSpawnType.MOB_SUMMONED);
							if (entityToSpawn != null) {
								entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
							}
						}
					}
					SurvivalReimaginedMod.queueServerWork(1, () -> {
						if (!entity.level().isClientSide())
							entity.discard();
					});
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}