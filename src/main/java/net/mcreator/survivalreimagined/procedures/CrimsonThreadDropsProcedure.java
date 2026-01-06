package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;
import net.mcreator.survivalreimagined.entity.CrimsonArachnidEntity;
import net.mcreator.survivalreimagined.entity.AlphaCrimsonArachnidEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CrimsonThreadDropsProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof CrimsonArachnidEntity) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
					if (Math.random() < 0.3) {
						for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 2, 4); index0++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SurvivalReimaginedModItems.CRIMSON_THREAD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
					if (Math.random() < 0.35) {
						for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 3, 5); index1++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SurvivalReimaginedModItems.CRIMSON_THREAD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
					if (Math.random() < 0.5) {
						for (int index2 = 0; index2 < Mth.nextInt(RandomSource.create(), 4, 6); index2++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SurvivalReimaginedModItems.CRIMSON_THREAD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
			} else {
				if (Math.random() < 0.2) {
					for (int index3 = 0; index3 < Mth.nextInt(RandomSource.create(), 1, 2); index3++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SurvivalReimaginedModItems.CRIMSON_THREAD.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		} else if (entity instanceof AlphaCrimsonArachnidEntity) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 1) {
					if (Math.random() < 0.3) {
						for (int index4 = 0; index4 < Mth.nextInt(RandomSource.create(), 2, 4); index4++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SurvivalReimaginedModItems.CRIMSON_THREAD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 2) {
					if (Math.random() < 0.35) {
						for (int index5 = 0; index5 < Mth.nextInt(RandomSource.create(), 3, 5); index5++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SurvivalReimaginedModItems.CRIMSON_THREAD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) == 3) {
					if (Math.random() < 0.5) {
						for (int index6 = 0; index6 < Mth.nextInt(RandomSource.create(), 4, 6); index6++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SurvivalReimaginedModItems.CRIMSON_THREAD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
			} else {
				if (Math.random() < 0.2) {
					for (int index7 = 0; index7 < Mth.nextInt(RandomSource.create(), 1, 2); index7++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()), new ItemStack(SurvivalReimaginedModItems.CRIMSON_THREAD.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}