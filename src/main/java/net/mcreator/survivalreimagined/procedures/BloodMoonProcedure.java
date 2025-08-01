package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class BloodMoonProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (world instanceof Level _lvl0 && _lvl0.isDay()) {
			if (SurvivalReimaginedModVariables.WorldVariables.get(world).BloodMoonChanceRan == 1) {
				SurvivalReimaginedModVariables.WorldVariables.get(world).isBloodMoon = false;
				SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
				SurvivalReimaginedModVariables.WorldVariables.get(world).BloodMoonChanceRan = 0;
				SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
			}
		} else {
			if (SurvivalReimaginedModVariables.WorldVariables.get(world).BloodMoonChanceRan == 0) {
				if (world.dimensionType().moonPhase(world.dayTime()) == 1) {
					if (Math.random() < 0.2) {
						SurvivalReimaginedModVariables.WorldVariables.get(world).isBloodMoon = true;
						SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
					}
				} else if (world.dimensionType().moonPhase(world.dayTime()) == 2 || world.dimensionType().moonPhase(world.dayTime()) == 3 || world.dimensionType().moonPhase(world.dayTime()) == 7
						|| world.dimensionType().moonPhase(world.dayTime()) == 8) {
					if (Math.random() < 0.15) {
						SurvivalReimaginedModVariables.WorldVariables.get(world).isBloodMoon = true;
						SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
					}
				} else if (world.dimensionType().moonPhase(world.dayTime()) == 4 || world.dimensionType().moonPhase(world.dayTime()) == 5 || world.dimensionType().moonPhase(world.dayTime()) == 6) {
					if (Math.random() < 0.125) {
						SurvivalReimaginedModVariables.WorldVariables.get(world).isBloodMoon = true;
						SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
					}
				}
				SurvivalReimaginedModVariables.WorldVariables.get(world).BloodMoonChanceRan = 1;
				SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
			}
		}
	}
}
