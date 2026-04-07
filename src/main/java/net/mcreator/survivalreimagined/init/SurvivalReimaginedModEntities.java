/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.survivalreimagined.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

import net.mcreator.survivalreimagined.entity.*;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

@EventBusSubscriber
public class SurvivalReimaginedModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, SurvivalReimaginedMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<BloodMoonZombieEntity>> BLOOD_MOON_ZOMBIE = register("blood_moon_zombie",
			EntityType.Builder.<BloodMoonZombieEntity>of(BloodMoonZombieEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(8).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<CrimsonArachnidEntity>> CRIMSON_ARACHNID = register("crimson_arachnid",
			EntityType.Builder.<CrimsonArachnidEntity>of(CrimsonArachnidEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.4f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<AlphaCrimsonArachnidEntity>> ALPHA_CRIMSON_ARACHNID = register("alpha_crimson_arachnid",
			EntityType.Builder.<AlphaCrimsonArachnidEntity>of(AlphaCrimsonArachnidEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.4f, 0.9f));
	public static final DeferredHolder<EntityType<?>, EntityType<BoarEntity>> BOAR = register("boar",
			EntityType.Builder.<BoarEntity>of(BoarEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<SowEntity>> SOW = register("sow", EntityType.Builder.<SowEntity>of(SowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.sized(0.6f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<PigletEntity>> PIGLET = register("piglet",
			EntityType.Builder.<PigletEntity>of(PigletEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<GhostEntity>> GHOST = register("ghost",
			EntityType.Builder.<GhostEntity>of(GhostEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(0.6f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		BloodMoonZombieEntity.init(event);
		CrimsonArachnidEntity.init(event);
		AlphaCrimsonArachnidEntity.init(event);
		BoarEntity.init(event);
		SowEntity.init(event);
		PigletEntity.init(event);
		GhostEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(BLOOD_MOON_ZOMBIE.get(), BloodMoonZombieEntity.createAttributes().build());
		event.put(CRIMSON_ARACHNID.get(), CrimsonArachnidEntity.createAttributes().build());
		event.put(ALPHA_CRIMSON_ARACHNID.get(), AlphaCrimsonArachnidEntity.createAttributes().build());
		event.put(BOAR.get(), BoarEntity.createAttributes().build());
		event.put(SOW.get(), SowEntity.createAttributes().build());
		event.put(PIGLET.get(), PigletEntity.createAttributes().build());
		event.put(GHOST.get(), GhostEntity.createAttributes().build());
	}
}