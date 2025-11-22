package net.mcreator.survivalreimagined.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.configuration.SurvivalReimaginedConfigConfiguration;

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
		if (world.dayTime() % 24000 >= 0 && world.dayTime() % 24000 <= 12000) {
			SurvivalReimaginedModVariables.MapVariables.get(world).isDay = true;
			SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
		} else {
			SurvivalReimaginedModVariables.MapVariables.get(world).isDay = false;
			SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
		}
		if (SurvivalReimaginedModVariables.MapVariables.get(world).isDay == false) {
			if (SurvivalReimaginedModVariables.MapVariables.get(world).ValueSetBloodMoon == false) {
				SurvivalReimaginedModVariables.MapVariables.get(world).ValueSetBloodMoon = true;
				SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
				SurvivalReimaginedModVariables.MapVariables.get(world).BloodMoonChanceRan = Math.round(Mth.nextInt(RandomSource.create(), 0, 1000));
				SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
			}
			if (SurvivalReimaginedModVariables.MapVariables.get(world).BloodMoon < 1000) {
				SurvivalReimaginedModVariables.MapVariables.get(world).BloodMoon = Math.round(SurvivalReimaginedModVariables.MapVariables.get(world).BloodMoon + 1);
				SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
			}
			if (SurvivalReimaginedModVariables.MapVariables.get(world).BloodMoon == SurvivalReimaginedModVariables.MapVariables.get(world).BloodMoonChanceRan) {
				SurvivalReimaginedModVariables.MapVariables.get(world).BloodMoonChanceRan = 1001;
				SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
				if (world.dimensionType().moonPhase(world.dayTime()) == 1) {
					if (Math.random() < (double) SurvivalReimaginedConfigConfiguration.FULL_MOON.get()) {
						SurvivalReimaginedModVariables.MapVariables.get(world).isBloodMoon = true;
						SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
					}
				} else if (world.dimensionType().moonPhase(world.dayTime()) == 2 || world.dimensionType().moonPhase(world.dayTime()) == 3 || world.dimensionType().moonPhase(world.dayTime()) == 7
						|| world.dimensionType().moonPhase(world.dayTime()) == 8) {
					if (Math.random() < (double) SurvivalReimaginedConfigConfiguration.PHASES_ONE.get()) {
						SurvivalReimaginedModVariables.MapVariables.get(world).isBloodMoon = true;
						SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
					}
				} else if (world.dimensionType().moonPhase(world.dayTime()) == 4 || world.dimensionType().moonPhase(world.dayTime()) == 5 || world.dimensionType().moonPhase(world.dayTime()) == 6) {
					if (Math.random() < (double) SurvivalReimaginedConfigConfiguration.PHASES_TWO.get()) {
						SurvivalReimaginedModVariables.MapVariables.get(world).isBloodMoon = true;
						SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
					}
				}
			}
		} else {
			SurvivalReimaginedModVariables.MapVariables.get(world).BloodMoonChanceRan = 0;
			SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
			SurvivalReimaginedModVariables.MapVariables.get(world).BloodMoon = 0;
			SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
			SurvivalReimaginedModVariables.MapVariables.get(world).isBloodMoon = false;
			SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
			SurvivalReimaginedModVariables.MapVariables.get(world).ValueSetBloodMoon = false;
			SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
