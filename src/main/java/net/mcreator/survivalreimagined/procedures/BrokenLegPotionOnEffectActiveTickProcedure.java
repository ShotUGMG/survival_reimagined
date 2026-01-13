package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BrokenLegPotionOnEffectActiveTickProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(SurvivalReimaginedModMobEffects.BROKEN_LEG_POTION)) == true) {
			entity.getPersistentData().putDouble("Clock", (entity.getPersistentData().getDouble("Clock") + 1));
			if (entity.getPersistentData().getDouble("Clock") == 200) {
				entity.getPersistentData().putDouble("Clock", 0);
			}
		}
	}
}