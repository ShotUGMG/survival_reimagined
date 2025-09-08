package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;
import net.mcreator.survivalreimagined.SurvivalReimaginedMod;

public class SolarEclipseProcedure {
	public static void execute(LevelAccessor world) {
		if (!(world instanceof Level _lvl0 && _lvl0.isDay())) {
			if (SurvivalReimaginedModVariables.WorldVariables.get(world).EclipseChanceRan == 1 || SurvivalReimaginedModVariables.WorldVariables.get(world).EclipseChanceRan == 2) {
				SurvivalReimaginedModVariables.WorldVariables.get(world).isSolarEclipse = false;
				SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
				SurvivalReimaginedModVariables.WorldVariables.get(world).EclipseChanceRan = 0;
				SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
			}
		} else {
			if (SurvivalReimaginedModVariables.WorldVariables.get(world).EclipseChanceRan == 0) {
				if (Math.random() < 0.1) {
					SurvivalReimaginedModVariables.WorldVariables.get(world).isSolarEclipse = true;
					SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
					SurvivalReimaginedModVariables.WorldVariables.get(world).EclipseChanceRan = 1;
					SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
				} else {
					SurvivalReimaginedModVariables.WorldVariables.get(world).EclipseChanceRan = 2;
					SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
					SurvivalReimaginedMod.queueServerWork(3000, () -> {
						SurvivalReimaginedModVariables.WorldVariables.get(world).EclipseChanceRan = 0;
						SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
					});
				}
			}
		}
	}
}
