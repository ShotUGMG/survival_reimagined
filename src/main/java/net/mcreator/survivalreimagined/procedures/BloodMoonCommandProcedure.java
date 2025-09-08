package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

public class BloodMoonCommandProcedure {
	public static void execute(LevelAccessor world) {
		SurvivalReimaginedModVariables.MapVariables.get(world).isBloodMoon = true;
		SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
		SurvivalReimaginedModVariables.WorldVariables.get(world).BloodMoonChanceRan = 1;
		SurvivalReimaginedModVariables.WorldVariables.get(world).syncData(world);
	}
}
