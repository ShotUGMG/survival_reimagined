package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModEntities;
import net.mcreator.survivalreimagined.entity.GhostEntity;
import net.mcreator.survivalreimagined.configuration.SurvivalReimaginedConfigConfiguration;

import javax.annotation.Nullable;

import java.util.Comparator;

@EventBusSubscriber
public class GhostSpawnProcedure {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double PlayerX = 0;
		double PlayerZ = 0;
		if (SurvivalReimaginedConfigConfiguration.GHOST_SPAWN.get() == true) {
			if (entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES).PlayerPositionSet == false) {
				PlayerX = entity.getX();
				PlayerZ = entity.getZ();
				{
					SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
					_vars.PlayerPositionSet = true;
					_vars.markSyncDirty();
				}
			}
			if (!(!world.getEntitiesOfClass(GhostEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3((entity.getX()), (entity.getY()), (entity.getZ()))).inflate(1000 / 2d), e -> true).isEmpty())) {
				if (SurvivalReimaginedModVariables.WorldVariables.get(world).GhostSpawnNumberVariable == 0) {
					SurvivalReimaginedModVariables.WorldVariables.get(world).GhostSpawnNumberVariable = Math.round(Mth.nextDouble(RandomSource.create(), 0, 4000));
					SurvivalReimaginedModVariables.WorldVariables.get(world).markSyncDirty();
				}
				SurvivalReimaginedModVariables.WorldVariables.get(world).GhostSpawnChance = SurvivalReimaginedModVariables.WorldVariables.get(world).GhostSpawnChance + 1;
				SurvivalReimaginedModVariables.WorldVariables.get(world).markSyncDirty();
				if (SurvivalReimaginedModVariables.WorldVariables.get(world).GhostSpawnChance >= SurvivalReimaginedModVariables.WorldVariables.get(world).GhostSpawnNumberVariable) {
					SurvivalReimaginedModVariables.WorldVariables.get(world).GhostSpawnNumberVariable = 0;
					SurvivalReimaginedModVariables.WorldVariables.get(world).GhostSpawnChance = 0;
					SurvivalReimaginedModVariables.WorldVariables.get(world).markSyncDirty();
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = SurvivalReimaginedModEntities.GHOST.get().spawn(_level, BlockPos.containing(PlayerX + Mth.nextDouble(RandomSource.create(), -150, 150),
								world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) PlayerX, (int) PlayerZ), PlayerZ + Mth.nextDouble(RandomSource.create(), -150, 150)), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			} else {
				SurvivalReimaginedModVariables.WorldVariables.get(world).GhostDespawnTimer = SurvivalReimaginedModVariables.WorldVariables.get(world).GhostDespawnTimer + 1;
				SurvivalReimaginedModVariables.WorldVariables.get(world).markSyncDirty();
				if (SurvivalReimaginedModVariables.WorldVariables.get(world).GhostDespawnTimer == 4000) {
					SurvivalReimaginedModVariables.WorldVariables.get(world).GhostDespawnTimer = 0;
					SurvivalReimaginedModVariables.WorldVariables.get(world).GhostSpawnChance = 0;
					SurvivalReimaginedModVariables.WorldVariables.get(world).GhostSpawnNumberVariable = 0;
					SurvivalReimaginedModVariables.WorldVariables.get(world).markSyncDirty();
					if (!(findEntityInWorldRange(world, GhostEntity.class, (entity.getX()), (entity.getY()), (entity.getZ()), 1000)).level().isClientSide())
						(findEntityInWorldRange(world, GhostEntity.class, (entity.getX()), (entity.getY()), (entity.getZ()), 1000)).discard();
					{
						SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
						_vars.PlayerPositionSet = false;
						_vars.markSyncDirty();
					}
				}
			}
			if (!world.getEntitiesOfClass(GhostEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3((entity.getX()), (entity.getY()), (entity.getZ()))).inflate(30 / 2d), e -> true).isEmpty()) {
				if (!(findEntityInWorldRange(world, GhostEntity.class, (entity.getX()), (entity.getY()), (entity.getZ()), 30)).level().isClientSide())
					(findEntityInWorldRange(world, GhostEntity.class, (entity.getX()), (entity.getY()), (entity.getZ()), 30)).discard();
				SurvivalReimaginedModVariables.WorldVariables.get(world).GhostDespawnTimer = 0;
				SurvivalReimaginedModVariables.WorldVariables.get(world).GhostSpawnChance = 0;
				SurvivalReimaginedModVariables.WorldVariables.get(world).GhostSpawnNumberVariable = 0;
				SurvivalReimaginedModVariables.WorldVariables.get(world).markSyncDirty();
				{
					SurvivalReimaginedModVariables.PlayerVariables _vars = entity.getData(SurvivalReimaginedModVariables.PLAYER_VARIABLES);
					_vars.PlayerPositionSet = false;
					_vars.markSyncDirty();
				}
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(30 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
						if (entityiterator instanceof GhostEntity == true) {
							for (int index186 = 0; index186 < 15; index186++) {
								world.addParticle(ParticleTypes.WHITE_SMOKE, (entityiterator.getX() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), (entityiterator.getY() + Mth.nextDouble(RandomSource.create(), 0, 2)),
										(entityiterator.getZ() + Mth.nextDouble(RandomSource.create(), -0.5, 0.5)), 0, 0.05, 0);
							}
						}
					}
				}
				MessagesProcedure.execute(entity);
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}