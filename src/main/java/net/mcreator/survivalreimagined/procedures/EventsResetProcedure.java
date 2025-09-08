package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

public class EventsResetProcedure {
	public static void execute(LevelAccessor world) {
		SurvivalReimaginedModVariables.WorldVariables.get(world).isSolarEclipse = false;
		SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
		SurvivalReimaginedModVariables.MapVariables.get(world).isBloodMoon = false;
		SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
	}
}
