package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;

import javax.annotation.Nullable;

@EventBusSubscriber
public class LapisInfusedWeaponProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		execute(null, world, x, y, z, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("c:rmi_infusable/weapon")))
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("LapisInfused") == true) {
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("GoldInfused") == true) {
				if (Math.random() < 0.2) {
					for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
						if (world instanceof ServerLevel _level)
							_level.addFreshEntity(new ExperienceOrb(_level, (x + 0.5), y, (z + 0.5), Mth.nextInt(RandomSource.create(), 3, 7)));
					}
				}
			} else if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("SilverInfused") == true) {
				if (Math.random() < 0.1) {
					for (int index1 = 0; index1 < Mth.nextInt(RandomSource.create(), 1, 3); index1++) {
						if (world instanceof ServerLevel _level)
							_level.addFreshEntity(new ExperienceOrb(_level, (x + 0.5), y, (z + 0.5), Mth.nextInt(RandomSource.create(), 1, 3)));
					}
				}
			}
		}
	}
}