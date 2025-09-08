package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

public class SolarEclipseCommandProcedure {
	public static void execute(LevelAccessor world) {
		SurvivalReimaginedModVariables.WorldVariables.get(world).isSolarEclipse = true;
		SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
	}
}
