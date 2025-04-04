package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FullMoonProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (world.dimensionType().moonPhase(world.dayTime()) == 0) {
			SurvivalReimaginedModVariables.MapVariables.get(world).isFullMoon = true;
			SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
		} else {
			SurvivalReimaginedModVariables.MapVariables.get(world).isFullMoon = false;
			SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
