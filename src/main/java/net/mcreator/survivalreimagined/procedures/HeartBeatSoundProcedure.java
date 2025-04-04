package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.init.SurvivalReimaginedModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HeartBeatSoundProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Pre event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(SurvivalReimaginedModMobEffects.FEAR)) {
			SurvivalReimaginedModVariables.WorldVariables.get(world).HeartBeat = SurvivalReimaginedModVariables.WorldVariables.get(world).HeartBeat + 1;
			SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
		} else if (SurvivalReimaginedModVariables.WorldVariables.get(world).HeartBeat == 100) {
			SurvivalReimaginedModVariables.WorldVariables.get(world).HeartBeat = 0;
			SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
