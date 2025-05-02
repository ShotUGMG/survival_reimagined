package net.mcreator.survivalreimagined.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.survivalreimagined.network.SurvivalReimaginedModVariables;

public class BindingSculkEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world) {
		SurvivalReimaginedModVariables.MapVariables.get(world).sculk_hearts = true;
		SurvivalReimaginedModVariables.MapVariables.get(world).syncData(world);
	}
}
