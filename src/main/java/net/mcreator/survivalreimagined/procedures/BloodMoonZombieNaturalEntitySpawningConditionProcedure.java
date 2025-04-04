package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

public class BloodMoonZombieNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world) {
		if (SurvivalReimaginedModVariables.WorldVariables.get(world).isBloodMoon == true) {
			return true;
		}
		return false;
	}
}
