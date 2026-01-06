package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class EmeraldInfusedToolProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:rmi_infusable/tool")))
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("EmeraldInfused") == true) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("minecraft:pickaxes")))) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("c:ores")))) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GoldInfused") == true) {
						if (Math.random() < 0.2) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(SurvivalReimaginedModItems.ROUGH_EMERALD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SilverInfused") == true) {
						if (Math.random() < 0.1) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(SurvivalReimaginedModItems.ROUGH_EMERALD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("minecraft:shovels")))) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/shovel")))) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GoldInfused") == true) {
						if (Math.random() < 0.15) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(SurvivalReimaginedModItems.ROUGH_EMERALD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SilverInfused") == true) {
						if (Math.random() < 0.075) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(SurvivalReimaginedModItems.ROUGH_EMERALD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("minecraft:axes")))) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:logs")))) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GoldInfused") == true) {
						if (Math.random() < 0.15) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(SurvivalReimaginedModItems.ROUGH_EMERALD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SilverInfused") == true) {
						if (Math.random() < 0.075) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(SurvivalReimaginedModItems.ROUGH_EMERALD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("minecraft:hoes")))) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/hoe")))) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GoldInfused") == true) {
						if (Math.random() < 0.15) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(SurvivalReimaginedModItems.ROUGH_EMERALD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SilverInfused") == true) {
						if (Math.random() < 0.075) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), y, (z + 0.5), new ItemStack(SurvivalReimaginedModItems.ROUGH_EMERALD.get()));
								entityToSpawn.setPickUpDelay(10);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					}
				}
			}
		}
	}
}